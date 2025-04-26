import React from "react";
import SciencePlanData from "../data/SciencePlanData";

const SciencePlanCard = ({ filterStatus }) => {
  const filteredData =
    filterStatus === "all"
      ? SciencePlanData
      : SciencePlanData.filter((item) => item.status === filterStatus);

  return (
    <div className="grid grid-cols-1 sm:grid-cols-2 lg:grid-cols-3 gap-6 ">
      {filteredData.map((item) => (
        <div
          key={item.id}
          className="rounded-2xl shadow-md p-6 bg-white/30 backdrop-blur-md border border-white/40 hover:shadow-lg transition-shadow"
        >
          <div className="flex justify-between items-center mb-3">
            <h2 className="text-xl font-semibold">#{item.id}</h2>
            <span
              className={`inline-block  px-3 py-1 text-sm rounded-full ${
                item.status === "validated"
                  ? "bg-green-100 text-green-700"
                  : "bg-gray-100 text-gray-700"
              }`}
            >
              {item.status}
            </span>
          </div>
          <h2 className="text-xl font-semibold mb-2">{item.planName}</h2>
          <p className="text-black mb-1">Created by: {item.create}</p>
        </div>
      ))}
    </div>
  );
};

export default SciencePlanCard;
