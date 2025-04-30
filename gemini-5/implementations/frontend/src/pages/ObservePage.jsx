import React from "react";
import SciencePlanCard from "../components/SciencePlanCard";

const ObservePage = ({authUser}) => {
  return (
    <div className={"max-w-[80%] m-auto my-10"}>
      <h1 className={"text-white font-extrabold text-5xl mb-10"}>Create Observing Program</h1>
      <SciencePlanCard filterStatus={"VALIDATED"} authUser={authUser}/>
    </div>
  );
};

export default ObservePage;
