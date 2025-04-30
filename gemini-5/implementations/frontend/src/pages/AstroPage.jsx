import React from "react";
import SciencePlanCard from "../components/SciencePlanCard";

const AstroPage = ({ authUser }) => {
  return (
    <div className={"max-w-[80%] m-auto my-10"}>
      <h1 className={"text-white font-extrabold text-5xl mb-10"}>Access Astronomer Data</h1>
      <SciencePlanCard filterStatus={"COMPLETE"} authUser={authUser}/>
    </div>
  );
};

export default AstroPage;