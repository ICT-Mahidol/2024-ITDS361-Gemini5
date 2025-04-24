import React, { useState } from "react";
import { useNavigate } from "react-router-dom";
import { FaUserAlt, FaLock, FaEnvelope, FaPhone } from "react-icons/fa";


const SignupForm = () => {
    const [firstName, setFirstName] = useState("");
    const [lastName, setLastName] = useState("");
    const [username, setUsername] = useState("");
    const [email, setEmail] = useState("");
    const [phone, setPhone] = useState("");
    const [password, setPassword] = useState("");
    const [confirmPassword, setconfirmPassword] = useState("");
    const [role, setRole] = useState("")
    const navigate = useNavigate();

  const handleSignup = async (e) => {
    e.preventDefault();

    // Validation ก่อนส่งฟอร์ม
    const emailPattern = /^[^\s@]+@[^\s@]+\.[^\s@]+$/;
    const phonePattern = /^0\d{9}$/;
    const passwordPattern = /^.{8,}$/; 

    if (!emailPattern.test(email)) {
        alert("Invalid email format!");
        return;
    }
    if (!phonePattern.test(phone)) {
        alert("Phone number must be 10 digits and start with 0!");
        return;
    }
    if (!passwordPattern.test(password)) {
      alert("Password must be at least 8 characters!");
      return;
    }

    console.log("Password: ", password);
    console.log("Confirm Password: ", confirmPassword);

    const newUser = { firstName, lastName, username, email, phone, password, confirmPassword, role };
    console.log("Submitting user:", newUser);

    const response = await fetch("http://localhost:8080/signup", {
        method: "POST",
        headers: { "Content-Type": "application/json" },
        body: JSON.stringify(newUser),
    });

    if (response.ok) {
        alert("Registration successful!");
        navigate("/login");
    } else {
        const errorText = await response.text();
        alert(`Failed to register: ${errorText}`);
    }
  };

  return (
    <div className="flex justify-center items-center mt-10">
      <div className="max-w-sm w-full bg-white/10 rounded-lg backdrop-blur-lg shadow-2xl p-6 text-white transition-transform transform hover:scale-105">
        <form onSubmit={handleSignup}>
          <h1 className="text-2xl font-bold text-center mb-4">Sign Up</h1>
          {[
            { state: firstName, setState: setFirstName, placeholder: "First Name", Icon: FaUserAlt },
            { state: lastName, setState: setLastName, placeholder: "Last Name", Icon: FaUserAlt },
            { state: username, setState: setUsername, placeholder: "Username", Icon: FaUserAlt },
            { state: email, setState: setEmail, placeholder: "Email", Icon: FaEnvelope },
            { state: phone, setState: setPhone, placeholder: "Phone", Icon: FaPhone },
            { state: password, setState: setPassword, placeholder: "Password", Icon: FaLock, type: "password" },
            { state: confirmPassword, setState: setconfirmPassword, placeholder: "Confirm Password", Icon: FaLock, type: "password" },
          ].map(({ state, setState, placeholder, Icon, type = "text" }, index) => (
            <div key={index} className="flex items-center justify-center w-full mb-4">
              <Icon className="mr-3 text-white text-lg" />
              <input
                type={type}
                placeholder={placeholder}
                value={state}
                onChange={(e) => setState(e.target.value)}
                required
                className="w-full py-3 px-4 border border-white/30 rounded-full bg-white text-gray-900 placeholder-gray-500 focus:outline-none focus:ring-2 focus:ring-purple-400"
              />
            </div>
          ))}
          <div className="flex items-center justify-center w-full mb-4">
            <FaUserAlt className="mr-3 text-white text-lg" />
            <select
              value={role}
              onChange={(e) => setRole(e.target.value)}
              required
              className="w-full py-3 px-4 border border-white/30 rounded-full bg-white text-gray-900 focus:outline-none focus:ring-2 focus:ring-purple-400"
            >
              <option value="">Select Role</option>
              <option value="Astronomer">Astronomer</option>
              <option value="ScienceObserver">ScienceObserver</option>
            </select>
          </div>
          <button type="submit" className="w-full py-2 text-lg font-bold text-white rounded-full bg-gradient-to-r from-purple-700 to-purple-500 transition-transform transform hover:translate-y-[-3px] hover:shadow-md">
            Sign Up
          </button>
          <div className="mt-3 text-center text-sm">
            <p>
              Already have an account? <a href="/login" className="text-purple-300 font-bold hover:underline">Login</a>
            </p>
          </div>
        </form>
      </div>
    </div>
  );
};

export default SignupForm;