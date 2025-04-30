import React, { useState } from "react";
import toast from 'react-hot-toast';
import { useNavigate } from "react-router-dom";

const CreateObservingProgramModal = ({ isOpen, onClose, planID }) => {
  const navigate = useNavigate();

  const [formData, setFormData] = useState({
    geminiLocation: "",
    opticsPrimary: "",
    fstop: "", 
    opticsSecondaryRMS: "",
    scienceFoldMirrorDegree: "",
    scienceFoldMirrorType: "",
    moduleContent: "",
    calibrationUnit: "",
    lightType: "",
    telescopeDirection: "",       
    telescopeDegree: "",         
  });

  const [error, setError] = useState("");

  const handleChange = (e) => {
    setFormData({ ...formData, [e.target.name]: e.target.value });
  };

  const handleSubmit = async (e) => {
    e.preventDefault();
    setError("");

    const {
      fstop,
      opticsSecondaryRMS,
      scienceFoldMirrorDegree,
      telescopeDirection,
      telescopeDegree,
    } = formData;

    const numericFields = {
      fstop: parseFloat(fstop),
      opticsSecondaryRMS: parseFloat(opticsSecondaryRMS),
      scienceFoldMirrorDegree: parseFloat(scienceFoldMirrorDegree),
      telescopeDirection: parseFloat(telescopeDirection),
      telescopeDegree: parseFloat(telescopeDegree),
    };

    const hasInvalid = Object.values(numericFields).some(isNaN);
    if (hasInvalid) {
      setError("Numeric fields must contain valid numbers.");
      return;
    }

    const payload = {
      planID,
      geminiLocation: formData.geminiLocation,
      opticsPrimary: formData.opticsPrimary,
      fstop: numericFields.fstop,
      opticsSecondaryRMS: numericFields.opticsSecondaryRMS,
      scienceFoldMirrorDegree: numericFields.scienceFoldMirrorDegree,
      scienceFoldMirrorType: formData.scienceFoldMirrorType,
      moduleContent: formData.moduleContent,
      calibrationUnit: formData.calibrationUnit,
      lightType: formData.lightType,
      telescopeDirection: numericFields.telescopeDirection,
      telescopeDegree: numericFields.telescopeDegree,
    };

    try {
      const response = await fetch("http://localhost:8080/api/observing-program/create", {
        method: "POST",
        headers: { "Content-Type": "application/json" },
        body: JSON.stringify(payload),
      });

      if (!response.ok) {
        const errorText = await response.text();
        console.error("Server responded with:", errorText);
        throw new Error("Failed to create observing program.");
      }

      toast.success('Create Success');
      navigate("/observation");
      onClose();
    } catch (err) {
      console.error(err);
      setError("Failed to create observing program.");
    }
  };

  if (!isOpen) return null;

  return (
    <div className="fixed inset-0 flex justify-center items-center z-50 bg-black/60 backdrop-blur-sm min-h-screen">
      <div className="bg-gray-300 p-8 rounded-2xl w-full max-w-lg relative">
        <h2 className="text-2xl font-bold mb-6 text-black">Create Observing Program</h2>

        <form className="grid grid-cols-1 gap-4 text-black" onSubmit={handleSubmit}>
          <input name="geminiLocation" placeholder="Gemini Location" onChange={handleChange} className="bg-gray-100 p-2 rounded" />
          <input name="opticsPrimary" placeholder="Optics Primary" onChange={handleChange} className="bg-gray-100 p-2 rounded" />
          <input name="fstop" type="number" step="any" placeholder="F-Stop" onChange={handleChange} className="bg-gray-100 p-2 rounded" />
          <input name="opticsSecondaryRMS" type="number" step="any" placeholder="Optics Secondary RMS" onChange={handleChange} className="bg-gray-100 p-2 rounded" />
          <input name="scienceFoldMirrorDegree" type="number" step="any" placeholder="Science Fold Mirror Degree" onChange={handleChange} className="bg-gray-100 p-2 rounded" />
          <input name="scienceFoldMirrorType" placeholder="Science Fold Mirror Type" onChange={handleChange} className="bg-gray-100 p-2 rounded" />
          <input name="moduleContent" placeholder="Module Content" onChange={handleChange} className="bg-gray-100 p-2 rounded" />
          <input name="calibrationUnit" placeholder="Calibration Unit" onChange={handleChange} className="bg-gray-100 p-2 rounded" />
          <input name="lightType" placeholder="Light Type" onChange={handleChange} className="bg-gray-100 p-2 rounded" />
          
          <input name="telescopeDirection" type="number" step="any" placeholder="Telescope Direction" onChange={handleChange} className="bg-gray-100 p-2 rounded" />
          <input name="telescopeDegree" type="number" step="any" placeholder="Telescope Degree" onChange={handleChange} className="bg-gray-100 p-2 rounded" />

          {error && <div className="text-red-600 mt-2">{error}</div>}

          <div className="flex justify-end gap-2 mt-6">
            <button type="button" className="px-4 py-2 bg-gray-50 rounded" onClick={onClose}>Cancel</button>
            <button type="submit" className="px-4 py-2 bg-black text-white rounded">Create</button>
          </div>
        </form>

        <button className="absolute top-4 right-4 text-gray-500 hover:text-gray-700" onClick={onClose}>✕</button>
      </div>
    </div>
  );
};

export default CreateObservingProgramModal;
