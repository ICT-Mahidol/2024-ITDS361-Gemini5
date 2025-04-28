import React from "react";
import { useParams } from "react-router-dom";
import SciencePlanData from "../data/SciencePlanData";

const SciplanDetailPage = () => {
  const { planId } = useParams();
  const plan = SciencePlanData.find((item) => item.planNo.toString() === planId);

  if (!plan) {
    return <div className="text-white">Plan not found</div>;
  }

  const {
    planNo,
    planName,
    creator,
    fundingInUSD,
    objectives,
    starSystem,
    startDate,
    endDate,
    telescopeLocation,
    status,
    DataProcRequirement,
  } = plan;

  return (
    <div className="max-w-4xl mx-auto my-10 p-8 rounded-3xl bg-white/30 backdrop-blur-md border border-white/40 text-black shadow-lg">
      <h1 className="text-4xl font-bold mb-6 text-white">General Information</h1>

      <div className="grid grid-cols-1 sm:grid-cols-2 gap-4 mb-10">
        <div><span className="font-bold">Plan ID:</span> {planNo}</div>
        <div><span className="font-bold">Plan Name:</span> {planName}</div>
        <div><span className="font-bold">Creator:</span> {creator}</div>
        <div><span className="font-bold">Funding:</span> {fundingInUSD.toLocaleString()} USD</div>
        <div className="sm:col-span-2">
          <span className="font-bold">Objective:</span> {objectives}
        </div>
        <div><span className="font-bold">Start Date:</span> {startDate}</div>
        <div><span className="font-bold">End Date:</span> {endDate}</div>
        <div><span className="font-bold">Telescope assigned:</span> {telescopeLocation}</div>
        <div><span className="font-bold">Target:</span> {starSystem}</div>
        {/* <div><span className="font-bold">Status:</span> 
          <span className="ml-2 px-2 py-1 rounded-full bg-green-100 text-green-700 text-sm">{status}</span>
        </div> */}
      </div>

      <h2 className="text-3xl font-bold mb-4 text-white">Data Processing Requirement</h2>

      <div className="grid grid-cols-1 sm:grid-cols-2 gap-4">
        <div><span className="font-bold">File Type:</span> {DataProcRequirement.fileType}</div>
        <div><span className="font-bold">File Quality:</span> {DataProcRequirement.fileQuality}</div>
        <div><span className="font-bold">Color Type:</span> {DataProcRequirement.colorType}</div>
        <div><span className="font-bold">Contrast:</span> {DataProcRequirement.contrast}</div>
        <div><span className="font-bold">Brightness:</span> {DataProcRequirement.brightness}</div>
        <div><span className="font-bold">Saturation:</span> {DataProcRequirement.saturation}</div>
        <div><span className="font-bold">Highlights:</span> {DataProcRequirement.highlights}</div>
        <div><span className="font-bold">Exposure:</span> {DataProcRequirement.exposure}</div>
        <div><span className="font-bold">Shadows:</span> {DataProcRequirement.shadows}</div>
        <div><span className="font-bold">Whites:</span> {DataProcRequirement.whites}</div>
        <div><span className="font-bold">Blacks:</span> {DataProcRequirement.blacks}</div>
        <div><span className="font-bold">Luminance:</span> {DataProcRequirement.luminance}</div>
        <div><span className="font-bold">Hue:</span> {DataProcRequirement.hue}</div>
      </div>
    
      {status === 'validated' && (
        <div className="bg-black w-fit text-white px-5 py-3 rounded-xl mt-10">
            Create Observing Program
        </div>
        )}
    </div>
  );
};

export default SciplanDetailPage;
