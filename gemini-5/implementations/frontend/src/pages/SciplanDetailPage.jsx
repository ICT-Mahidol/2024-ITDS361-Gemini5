import React, { useEffect, useState } from "react";
import { useParams } from "react-router-dom";
import ObservingProgramData from "../data/ObservingProgramData";
import CreateObservingProgramModal from "../components/CreateObservingProgramModal";

const SciplanDetailPage = ({ authUser }) => {
  const { planId } = useParams();
  const [plan, setPlan] = useState(null);
  const [loading, setLoading] = useState(true);
  const [isModalOpen, setIsModalOpen] = useState(false);

  useEffect(() => {
    fetch(`http://localhost:8080/sp/${planId}`)
      .then((res) => {
        if (!res.ok) {
          throw new Error("Failed to fetch science plan");
        }
        return res.json();
      })
      .then((data) => {
        setPlan(data);
        setLoading(false);
      })
      .catch((err) => {
        console.error(err);
        setLoading(false);
      });
  }, [planId]);

  const observingProgram = ObservingProgramData.find(
    (program) => program.planNo.toString() === planId
  );

  if (loading) {
    return <div className="text-white flex items-center justify-center min-h-screen"><h1 className="text-4xl font-bold">Loading...</h1></div>;
  }

  if (!plan) {
    return <div className="text-white flex items-center justify-center min-h-screen"><h1 className="text-4xl font-bold">PLAN NOT FOUND</h1></div>;
  }

  const {
    planNo,
    submitter,
    creator,
    fundingInUSD,
    objectives,
    starSystem,
    startDate,
    endDate,
    telescopeLocation,
    status,
    dataProcRequirements,
  } = plan;

  const dataProc = dataProcRequirements?.[0] || {};

  return (
    <div className="max-w-4xl mx-auto my-10 p-8 rounded-3xl bg-white/30 backdrop-blur-md border border-white/40 text-black shadow-lg">
      <h1 className="text-4xl font-bold mb-6 text-white">General Information</h1>

      <div className="grid grid-cols-1 sm:grid-cols-2 gap-4 mb-10">
        <div><span className="font-bold">Plan ID:</span> {planNo}</div>
        <div><span className="font-bold">Submitter:</span> {submitter}</div>
        <div><span className="font-bold">Creator:</span> {creator}</div>
        <div><span className="font-bold">Funding:</span> {fundingInUSD.toLocaleString()} USD</div>
        <div className="sm:col-span-2">
          <span className="font-bold">Objective:</span> {objectives}
        </div>
        <div><span className="font-bold">Start Date:</span> {startDate}</div>
        <div><span className="font-bold">End Date:</span> {endDate}</div>
        <div><span className="font-bold">Telescope assigned:</span> {telescopeLocation}</div>
        <div><span className="font-bold">Target:</span> {starSystem}</div>
      </div>

      <h2 className="text-3xl font-bold mb-4 text-white">Data Processing Requirement</h2>

      <div className="grid grid-cols-1 sm:grid-cols-2 gap-4">
        <div><span className="font-bold">File Type:</span> {dataProc.fileType}</div>
        <div><span className="font-bold">File Quality:</span> {dataProc.fileQuality}</div>
        <div><span className="font-bold">Color Type:</span> {dataProc.colorType}</div>
        <div><span className="font-bold">Contrast:</span> {dataProc.contrast}</div>
        <div><span className="font-bold">Brightness:</span> {dataProc.brightness}</div>
        <div><span className="font-bold">Saturation:</span> {dataProc.saturation}</div>
        <div><span className="font-bold">Highlights:</span> {dataProc.highlights}</div>
        <div><span className="font-bold">Exposure:</span> {dataProc.exposure}</div>
        <div><span className="font-bold">Shadows:</span> {dataProc.shadows}</div>
        <div><span className="font-bold">Whites:</span> {dataProc.whites}</div>
        <div><span className="font-bold">Blacks:</span> {dataProc.blacks}</div>
        <div><span className="font-bold">Luminance:</span> {dataProc.luminance}</div>
        <div><span className="font-bold">Hue:</span> {dataProc.hue}</div>
      </div>

      {status === "VALIDATED" && authUser.role === "ScienceObserver" && (
        <div
          onClick={() => setIsModalOpen(true)}
          className="bg-black w-fit text-white px-5 py-3 rounded-xl mt-10 cursor-pointer"
        >
          Create Observing Program
        </div>
      )}

      {status === "COMPLETE" && observingProgram && (
        <>
          <h2 className="text-3xl font-bold mb-4 text-white mt-10">Observing Program Information</h2>
          <div className="grid grid-cols-1 sm:grid-cols-2 gap-4">
            <div><span className="font-bold">Gemini Location:</span> {observingProgram.geminiLocation}</div>
            <div><span className="font-bold">Optics Primary:</span> {observingProgram.opticsPrimary}</div>
            <div><span className="font-bold">F-Stop:</span> {observingProgram.fStop}</div>
            <div><span className="font-bold">Optics Secondary RMS:</span> {observingProgram.opticsSecondaryRMS}</div>
            <div><span className="font-bold">Science Fold Mirror Degree:</span> {observingProgram.scienceFoldMirrorDegree}</div>
            <div><span className="font-bold">Science Fold Mirror Type:</span> {observingProgram.scienceFoldMirrorType}</div>
            <div><span className="font-bold">Module Content:</span> {observingProgram.moduleContent}</div>
            <div><span className="font-bold">Calibration Unit:</span> {observingProgram.calibrationUnit}</div>
            <div><span className="font-bold">Light Type:</span> {observingProgram.lightType}</div>
            <div><span className="font-bold">Telescope Position Pair:</span> {observingProgram.telescopePositionPair}</div>
            <div><span className="font-bold">Status:</span> {observingProgram.status}</div>
          </div>
        </>
      )}

      <CreateObservingProgramModal isOpen={isModalOpen} onClose={() => setIsModalOpen(false)} />
    </div>
  );
};

export default SciplanDetailPage;
