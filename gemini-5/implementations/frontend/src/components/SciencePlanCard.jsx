import React, { useEffect, useState } from "react";
import { useNavigate } from "react-router-dom";

const SciencePlanCard = ({ filterStatus, authUser }) => {
  const [sciencePlans, setSciencePlans] = useState([]);
  const [observingProgramsMap, setObservingProgramsMap] = useState({});
  const navigate = useNavigate();

  useEffect(() => {
    const fetchSciencePlans = async () => {
      try {
        const response = await fetch("http://localhost:8080/sp/all");
        const data = await response.json();
        setSciencePlans(data);

       // Fetch all observing programs based on planNo
        const programPromises = data.map((plan) =>
        fetch(`http://localhost:8080/api/observing-program/${plan.planNo}`)
          .then((res) => {
            if (res.status === 400 || res.status === 404) return null;
            if (!res.ok) throw new Error("Failed to fetch observing program");
            return res.json();
          })
          .catch(() => null)
        );

        const results = await Promise.all(programPromises);
        const newMap = {};
        data.forEach((plan, index) => {
          if (results[index]) {
            newMap[plan.planNo] = results[index];
          }
        });
        setObservingProgramsMap(newMap);

      } catch (error) {
        console.error("Failed to fetch science plans:", error);
      }
    };

    fetchSciencePlans();
  }, []);

  // กำหนด role-based status visibility
  const astronomerStatuses = ["created", "saved", "tested","complete"];
  const scienceObserverStatuses = [
    "submitted",
    "invalidated",
    "validated",
    "running",
    "complete",
    "cancelled",
  ];

  const allowedStatuses =
    authUser.role === "Astronomer"
      ? astronomerStatuses
      : scienceObserverStatuses;

  const filteredData = sciencePlans.filter((item) => {
    const itemStatus = item.status.toLowerCase();
    const isAllowed = allowedStatuses.includes(itemStatus);
    if (filterStatus === "all") return isAllowed;
    return isAllowed && itemStatus === filterStatus.toLowerCase();
  });

  const handleCardClick = (planNo) => {
    navigate(`/sciplan/${planNo}`);
  };

  return (
    <div className="grid grid-cols-1 sm:grid-cols-2 lg:grid-cols-3 gap-6">
      {filteredData.length === 0 ? (
        <div className="text-center mt-52 col-span-full text-white font-bold text-xl">
          No {filterStatus.toLowerCase()} science plans found.
        </div>
      ) : (
        filteredData.map((item) => {
          const observingProgram = observingProgramsMap[item.planNo];

          return (
            <div
              key={item.planNo}
              onClick={() => handleCardClick(item.planNo)}
              className="rounded-2xl shadow-md p-6 bg-white/30 backdrop-blur-md border border-white/40 hover:shadow-lg transition-shadow hover:cursor-pointer"
            >
              <div className="flex justify-between items-center mb-3">
                <h2 className="text-xl font-semibold">#{item.planNo}</h2>
                <span
                  className={`px-3 py-1 text-sm rounded-full flex items-center gap-2 ${
                    {
                      saved: "bg-blue-100 text-blue-700",
                      created: "bg-indigo-100 text-indigo-700",
                      tested: "bg-yellow-100 text-yellow-700",
                      submitted: "bg-orange-100 text-orange-700",
                      validated: "bg-green-100 text-green-700",
                      running: "bg-yellow-100 text-yellow-700",
                      invalidated: "bg-red-100 text-red-700",
                      complete: "bg-emerald-100 text-emerald-700",
                      cancelled: "bg-gray-300 text-gray-700",
                    }[item.status.toLowerCase()] || "bg-gray-100 text-gray-700"
                  }`}
                >
                  <div
                    className={`rounded-full w-2 h-2 ${
                      {
                        saved: "bg-blue-700",
                        created: "bg-indigo-700",
                        tested: "bg-yellow-700",
                        submitted: "bg-orange-700",
                        validated: "bg-green-700",
                        running: "bg-yellow-700",
                        invalidated: "bg-red-700",
                        complete: "bg-emerald-700",
                        cancelled: "bg-gray-700",
                      }[item.status.toLowerCase()] || "bg-gray-700"
                    }`}
                  ></div>
                  {item.status}
                </span>
              </div>
              <p className="text-black mt-5 mb-1">
                <span className="font-bold">Submit by:</span> {item.submitter}
              </p>
              <p className="text-black mb-1">
                <span className="font-bold">Created by:</span> {item.creator}
              </p>
              {observingProgram && (
                <p className="text-black mb-1">
                  <span className="font-bold">Observing Program:</span>{" "}
                  validated
                </p>
              )}
            </div>
          );
        })
      )}
    </div>
  );
};

export default SciencePlanCard;
