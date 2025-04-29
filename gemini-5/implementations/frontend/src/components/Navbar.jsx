import React from "react";
import { Link } from "react-router-dom";
import { FaUserCircle } from "react-icons/fa";

const Navbar = ({ authUser }) => {
  // เงื่อนไข role-based filtering
  const navItems = [
    { name: "Home", path: "/home", roles: ["Astronomer", "ScienceObserver"] },
    { name: "Create an Observing Program", path: "/observation", roles: ["ScienceObserver"] },
    { name: "Access Astronomical Data", path: "/astrodata", roles: ["Astronomer"] },
    { name: "Science Plans", path: "/sciplan", roles: ["Astronomer", "ScienceObserver"] },
  ];

  return (
    <div className=" w-full h-[80px] px-6 flex justify-between items-center z-[99]">
      <Link
        to="/home"
        className="text-2xl font-bold text-white select-none no-underline"
      >
        Gemini
      </Link>

      <nav className="flex items-center gap-5">
        {authUser &&
          navItems
            .filter(item => item.roles.includes(authUser.role)) // 🔍 filter by role
            .map((item, index) => (
              <Link
                key={index}
                to={item.path}
                className="relative text-lg text-white font-medium no-underline ml-5 group"
              >
                {item.name}
                <span className="absolute left-0 bottom-[-6px] w-full h-[3px] bg-white rounded-md scale-x-0 group-hover:scale-x-100 transition-transform origin-right group-hover:origin-left"></span>
              </Link>
            ))}

        {authUser ? (
          <Link to="/profile" className="text-white">
            <FaUserCircle size={28} />
          </Link>
        ) : (
          <Link
            to="/login"
            className="ml-5 px-6 py-3 text-lg font-bold text-white border-2 border-white rounded-md transition-all duration-300 flex items-center justify-center
            hover:bg-white hover:text-[#162938] hover:-translate-y-1 no-underline"
          >
            Login
          </Link>
        )}
      </nav>
    </div>
  );
};


export default Navbar;
