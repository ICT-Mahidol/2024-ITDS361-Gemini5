import React, { useState } from "react";
import SciencePlanCard from "../components/SciencePlanCard";

const SciplanPage = ({ authUser }) => {
  const [filterStatus, setFilterStatus] = useState("all");

  const handleFilterChange = (e) => {
    setFilterStatus(e.target.value);
  };

  const astronomerStatuses = ["CREATED", "SAVED", "TESTED"];
  const scienceObserverStatuses = [
    "SUBMITTED",
    "VALIDATED",
    "RUNNING",
    "INVALIDATED",
    "COMPLETE",
    "CANCELLED",
  ];

  let statusOptions = [];
  if (authUser.role === "Astronomer") {
    statusOptions = astronomerStatuses;
  } else if (authUser.role === "ScienceObserver") {
    statusOptions = scienceObserverStatuses;
  }

  return (
    <div className="max-w-[80%] m-auto my-10">
      <div className="flex justify-between items-center mb-10">
        <h1 className="text-white font-extrabold text-5xl">Science Plan</h1>
        <select
          className="bg-white/30 backdrop-blur-md border border-white/40 text-gray-800 p-2 rounded-md shadow-lg focus:outline-none"
          value={filterStatus}
          onChange={handleFilterChange}
        >
          <option value="all">All</option>
          {statusOptions.map((status, idx) => (
            <option key={idx} value={status}>
              {status.charAt(0).toUpperCase() + status.slice(1)}
            </option>
          ))}
        </select>
      </div>

      <SciencePlanCard filterStatus={filterStatus} authUser={authUser} />
    </div>
  );
};

export default SciplanPage;
