import React, { useEffect, useState } from "react";
import ObservingProgramData from "../data/ObservingProgramData";
import { useNavigate } from "react-router-dom";

const SciencePlanCard = ({ filterStatus }) => {
  const navigate = useNavigate();
  const [sciencePlans, setSciencePlans] = useState([]);
  const [loading, setLoading] = useState(true);

  useEffect(() => {
    fetch("http://localhost:8080/sp/all")
      .then((res) => res.json())
      .then((data) => {
        setSciencePlans(data);
        setLoading(false);
      })
      .catch((error) => {
        console.error("Error fetching science plans:", error);
        setLoading(false);
      });
  }, []);

  const filteredData =
    filterStatus === "all"
      ? sciencePlans
      : sciencePlans.filter((item) => item.status === filterStatus);

  const handleCardClick = (planNo) => {
    navigate(`/sciplan/${planNo}`);
  };

  if (loading) {
    return <p>Loading science plans...</p>;
  }

  return (
    <div className="grid grid-cols-1 sm:grid-cols-2 lg:grid-cols-3 gap-6">
      {filteredData.map((item) => {
        const observingProgram = ObservingProgramData.find(
          (program) => program.planNo === item.planNo
        );

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
                    SAVED: "bg-blue-100 text-blue-700",
                    CREATED: "bg-indigo-100 text-indigo-700",
                    TESTED: "bg-yellow-100 text-yellow-700",
                    SUBMITTED: "bg-orange-100 text-orange-700",
                    VALIDATED: "bg-green-100 text-green-700",
                    RUNNING: "bg-yellow-100 text-yellow-700",
                    INVALIDATED: "bg-red-100 text-red-700",
                    COMPLETE: "bg-emerald-100 text-emerald-700",
                    CANCELLED: "bg-gray-300 text-gray-700",
                  }[item.status] || "bg-gray-100 text-gray-700"
                }`}
              >
                <div
                  className={`rounded-full w-2 h-2 ${
                    {
                      SAVED: "bg-blue-700",
                      CREATED: "bg-indigo-700",
                      TESTED: "bg-yellow-700",
                      SUBMITTED: "bg-orange-700",
                      VALIDATED: "bg-green-700",
                      RUNNING: "bg-yellow-700",
                      INVALIDATED: "bg-red-700",
                      COMPLETE: "bg-emerald-700",
                      CANCELLED: "bg-gray-700",
                    }[item.status] || "bg-gray-700"
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
            {observingProgram ? (
              <p className="text-black mb-1">
                <span className="font-bold">Observing Program:</span>{" "}
                {observingProgram.status}
              </p>
            ) : (
              <p className="text-black mb-1">No Observing Program Found</p>
            )}
          </div>
        );
      })}
    </div>
  );
};

export default SciencePlanCard;
