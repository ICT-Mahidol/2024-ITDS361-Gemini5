import React from "react";
import Navbar from "./Navbar";

const Header = ({ authUser }) => {
  return (
    <header className="fixed top-0 left-0 w-full z-50">
      <Navbar authUser={authUser} />
    </header>
  );
};

export default Header;
