import React, { useState, useEffect } from "react";
import { useNavigate } from "react-router-dom";
import { FaEye, FaEyeSlash  } from "react-icons/fa";

import axios from "axios";


const ProfilePage = ({ authUser, setAuthUser }) => {
  const navigate = useNavigate();
  const [userData, setUserData] = useState(null);

  const [isEditing, setIsEditing] = useState(false);
  const [firstName, setFirstName] = useState("");
  const [lastName, setLastName] = useState("");
  const [email, setEmail] = useState("");
  const [username, setUsername] = useState("");
  const [phone, setPhone] = useState("");
  const [password, setPassword] = useState("");
  const [showPassword, setShowPassword] = useState(false);

  const togglePasswordVisibility = () => {
    setShowPassword((prev) => !prev);
  }

  const userId = authUser?.id;

  useEffect(() => {
    if (!userId) {
      navigate("/login");
      return;
    }

    const fetchUserData = async () => {
      try {
        const response = await axios.get(`http://localhost:8080/users/${userId}`);
        const data = response.data;
        setUserData(data);

        setFirstName(data.firstName);
        setLastName(data.lastName);
        setEmail(data.email);
        setUsername(data.username);
        setPhone(data.phone || "");
        setPassword(data.password || "");
      } catch (error) {
        console.error("Error fetching user data:", error);
        navigate("/login"); 
      }
    };
    fetchUserData();
  }, [userId, navigate]);

  const handleEdit = () => {
    setIsEditing(true);
  };

  const handleCancel = () => {
    setFirstName(userData.firstName);
    setLastName(userData.lastName);
    setEmail(userData.email);
    setUsername(userData.username);
    setPhone(userData.phone || "");
    setPassword(userData.password || "");
    setIsEditing(false);
  };

  const handleSave = async () => {
    try {
      const updatedData = { firstName, lastName, email, username, phone };

      if (password) {
        updatedData.password = password;
      }

      await axios.put(`http://localhost:8080/users/${userId}`, updatedData);

      setUserData(updatedData);
      setIsEditing(false);
      setPassword("");
    } catch (error) {
      console.error("Error updating user data:", error);
    }
  };

  const handleLogout = () => {
    setAuthUser(null);
    navigate("/login");
  };

  if (!userData) {
    return <p className="text-center text-gray-600">Loading...</p>;
  }

  return (
    <div className="flex justify-center items-center mt-10">
      <div className="bg-white bg-opacity-10 backdrop-blur-lg p-8 rounded-2xl shadow-lg w-full max-w-md text-center">
        <h1 className="text-white text-2xl font-semibold mb-4">User Profile</h1>

        <div className="space-y-3">
          <div className="text-left">
            <label className="text-white text-sm">First Name:</label>
            <input
              type="text"
              value={firstName}
              onChange={(e) => setFirstName(e.target.value)}
              className="w-full p-2 rounded-md bg-white bg-opacity-20 text-white outline-none"
              disabled={!isEditing}
            />
          </div>

          <div className="text-left">
            <label className="text-white text-sm">Last Name:</label>
            <input
              type="text"
              value={lastName}
              onChange={(e) => setLastName(e.target.value)}
              className="w-full p-2 rounded-md bg-white bg-opacity-20 text-white outline-none"
              disabled={!isEditing}
            />
          </div>

          <div className="text-left">
            <label className="text-white text-sm">Email:</label>
            <input
              type="email"
              value={email}
              onChange={(e) => setEmail(e.target.value)}
              className="w-full p-2 rounded-md bg-white bg-opacity-20 text-white outline-none"
              disabled={!isEditing}
            />
          </div>

          <div className="text-left">
            <label className="text-white text-sm">Username:</label>
            <input
              type="text"
              value={username}
              onChange={(e) => setUsername(e.target.value)}
              className="w-full p-2 rounded-md bg-white bg-opacity-20 text-white outline-none"
              disabled={!isEditing}
            />
          </div>

          <div className="text-left">
            <label className="text-white text-sm">Phone:</label>
            <input
              type="text"
              value={phone}
              onChange={(e) => setPhone(e.target.value)}
              className="w-full p-2 rounded-md bg-white bg-opacity-20 text-white outline-none"
              disabled={!isEditing}
            />
          </div>

          <div className="text-left">
            <label className="text-white text-sm">Password:</label>
            <div className="relative">
              <input
                type={showPassword ? "text" : "password"}
                value={showPassword ? password : "********"}
                onChange={(e) => setPassword(e.target.value)}
                className="w-full p-2 rounded-md bg-white bg-opacity-20 text-white outline-none pr-10"
                disabled={!isEditing}
              />
              <span
                className="absolute top-1/2 right-3 transform -translate-y-1/2 text-white cursor-pointer"
                onClick={togglePasswordVisibility}
              >
                {showPassword ? <FaEyeSlash /> : <FaEye />}
              </span>
            </div>
          </div>
        </div>

        {isEditing ? (
          <div className="mt-4 flex space-x-4 justify-center">
            <button
              onClick={handleSave}
              className="w-[150px] bg-[#28a745] text-white py-2 rounded-md font-bold hover:bg-[#38d760]"
            >
              Save
            </button>
            <button
              onClick={handleCancel}
              className="w-[150px] bg-[#e74c3c] text-white py-2 rounded-md font-bold hover:bg-[#f44336]"
            >
              Cancel
            </button>
          </div>
        ) : (
          <button
            onClick={handleEdit}
            className="w-[180px] mt-4 bg-[#7a7b7b] text-white py-2 rounded-md font-bold hover:bg-[#5d5d5e]"
          >
            Edit
          </button>
        )}

        <button
          onClick={handleLogout}
          className="w-full mt-4 bg-purple-700 text-white py-2 rounded-md font-bold hover:bg-purple-800"
        >
          Logout
        </button>
      </div>
    </div>
  );
};

export default ProfilePage;
