import React from "react";

const CreateObservingProgramModal = ({ isOpen, onClose }) => {
  if (!isOpen) return null; // ไม่แสดงถ้า isOpen เป็น false

  return (
    <div className="fixed inset-0 flex justify-center items-center z-50">
      <div className="bg-gray-300 p-8 rounded-2xl w-full max-w-lg relative">
        <h2 className="text-2xl font-bold mb-6 text-black">Create Observing Program</h2>

        <form className="grid grid-cols-1 gap-4 text-black">
          <input type="text" placeholder="Gemini Location" className="bg-gray-100 p-2 rounded" />
          <input type="text" placeholder="Optics Primary" className="bg-gray-100 p-2 rounded" />
          <input type="text" placeholder="F-Stop" className="bg-gray-100 p-2 rounded" />
          <input type="number" placeholder="Optics Secondary RMS" className="bg-gray-100 p-2 rounded" />
          <input type="number" placeholder="Science Fold Mirror Degree" className="bg-gray-100 p-2 rounded" />
          <input type="text" placeholder="Science Fold Mirror Type" className="bg-gray-100 p-2 rounded" />
          <input type="number" placeholder="Module Content" className="bg-gray-100 p-2 rounded" />
          <input type="number" placeholder="Calibration Unit" className="bg-gray-100 p-2 rounded" />
          <input type="text" placeholder="Light Type" className="bg-gray-100 p-2 rounded" />
          <input type="text" placeholder="Telescope Position Pair" className="bg-gray-100 p-2 rounded" />

          <div className="flex justify-end gap-2 mt-6">
            <button type="button" className="px-4 py-2 bg-gray-50 rounded" onClick={onClose}>
              Cancel
            </button>
            <button type="submit" className="px-4 py-2 bg-black text-white rounded">
              Create
            </button>
          </div>
        </form>

        {/* ปุ่มปิดมุมขวาบน */}
        <button
          className="absolute top-4 right-4 text-gray-500 hover:text-gray-700"
          onClick={onClose}
        >
          ✕
        </button>
      </div>
    </div>
  );
};

export default CreateObservingProgramModal;
