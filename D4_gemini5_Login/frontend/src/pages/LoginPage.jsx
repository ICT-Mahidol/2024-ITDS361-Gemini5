import React, { useState } from "react";
import { useNavigate, Link  } from "react-router-dom";
import { FaUserAlt, FaLock } from "react-icons/fa";


const LoginForm = ({ setAuthUser }) => {
  const [username, setUsername] = useState("");
  const [password, setPassword] = useState("");
  const navigate = useNavigate();

  const handleLogin = async (e) => {
    e.preventDefault();

    const response = await fetch("http://localhost:8080/login", {
      method: "POST",
      headers: { "Content-Type": "application/json" },
      body: JSON.stringify({ username, password }),
    });

    if (response.ok) {
      const userData  = await response.json();
      setAuthUser(userData);
      navigate("/home");
    } else {
      alert("Invalid email or password");
    }
  };

  return (
    <div className="flex justify-center items-center min-h-screen">
      <div className="max-w-md w-full bg-white/10 rounded-lg backdrop-blur-lg shadow-2xl p-10 text-white transition-transform transform hover:scale-105">
        <h1 className="text-3xl font-bold text-center mb-6">Login</h1>
        <form onSubmit={handleLogin}>
          <div className="flex items-center w-full mb-6 relative">
            <FaUserAlt className="mr-3 text-white text-lg" />
            <input
              type="text"
              placeholder="Username"
              onChange={(e) => setUsername(e.target.value)}
              required
              className="w-full p-3 pl-8 border border-white/30 rounded-full bg-white/20 text-white placeholder-gray-300 focus:outline-none focus:ring-2 focus:ring-purple-400"
            />
          </div>
          <div className="flex items-center w-full mb-6 relative">
            <FaLock className="mr-3 text-white text-lg" />
            <input
              type="password"
              placeholder="Password"
              onChange={(e) => setPassword(e.target.value)}
              required
              className="w-full p-3 pl-8 border border-white/30 rounded-full bg-white/20 text-white placeholder-gray-300 focus:outline-none focus:ring-2 focus:ring-purple-400"
            />
          </div>
          <button
            type="submit"
            className="w-full py-3 text-lg font-bold rounded-full bg-gradient-to-r from-purple-700 to-indigo-700 hover:from-purple-600 hover:to-indigo-600 shadow-lg transform hover:-translate-y-1 transition"
          >
            Login
          </button>
          <div className="mt-4 text-center text-sm">
            <p>
              Don't have an account?{' '}
              <Link to="/signup" className="text-purple-300 hover:underline">
                Sign Up
              </Link>
            </p>
          </div>
        </form>
      </div>
    </div>
  );
};

export default LoginForm;
