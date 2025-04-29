import React from "react";
import Navbar from "./Navbar";

const Header = ({ authUser }) => {
  return (
    <header className=" w-full z-50">
      <Navbar authUser={authUser} />
    </header>
  );
};

export default Header;
