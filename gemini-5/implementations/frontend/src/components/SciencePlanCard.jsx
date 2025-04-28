import React from "react";
import SciencePlanData from "../data/SciencePlanData";
import ObservingProgramData from "../data/ObservingProgramData"; // นำเข้าข้อมูล ObservingProgramData
import { useNavigate } from "react-router-dom";

const SciencePlanCard = ({ filterStatus }) => {
  const navigate = useNavigate();

  // กรองข้อมูล SciencePlanData ตาม filterStatus
  const filteredData =
    filterStatus === "all"
      ? SciencePlanData
      : SciencePlanData.filter((item) => item.status === filterStatus);

  const handleCardClick = (planNo) => {
    navigate(`/sciplan/${planNo}`); // กดแล้วพาไปหน้า detail
  };

  return (
    <div className="grid grid-cols-1 sm:grid-cols-2 lg:grid-cols-3 gap-6 ">
      {filteredData.map((item) => {
        // หาข้อมูล ObservingProgramData ที่มี planNo ตรงกัน
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
                    saved: "bg-blue-100 text-blue-700",
                    created: "bg-indigo-100 text-indigo-700",
                    tested: "bg-yellow-100 text-yellow-700",
                    submited: "bg-orange-100 text-orange-700",
                    validated: "bg-green-100 text-green-700",
                    running: "bg-yellow-100 text-yellow-700",
                    invalidated: "bg-red-100 text-red-700",
                    complete: "bg-emerald-100 text-emerald-700",
                    cancelled: "bg-gray-300 text-gray-700",
                  }[item.status] || "bg-gray-100 text-gray-700" // default สีเทา ถ้าไม่มีใน list
                }`}
              >
                <div
                  className={`rounded-full w-2 h-2 ${
                    {
                      saved: "bg-blue-700",
                      created: "bg-indigo-700",
                      tested: "bg-yellow-700",
                      submited: "bg-orange-700",
                      validated: "bg-green-700",
                      running: "bg-yellow-700",
                      invalidated: "bg-red-700",
                      complete: "bg-emerald-700",
                      cancelled: "bg-gray-700",
                    }[item.status] || "bg-gray-700"
                  }`}
                ></div>
                {item.status}
              </span>
            </div>
            <h2 className="text-xl font-semibold mb-2">{item.planName}</h2>
            <p className="text-black mt-5 mb-1"><span className="font-bold">Created by:</span> {item.creator}</p>
            {/* แสดงข้อมูล Observing Program ที่ตรงกับ planNo */}
            {observingProgram ? (
              <p className="text-black mb-1">
                <span className="font-bold">Observing Program:</span> {observingProgram.status}
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
