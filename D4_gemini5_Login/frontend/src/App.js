import Header from "./components/Header";

import GeminiHome from "./pages/GeminiHome";
import LoginPage from "./pages/LoginPage";
import SignupPage from "./pages/SignUpPage";
import ObservePage from "./pages/ObservePage";
import AstroPage from "./pages/AstroPage";
import SciplanPage from "./pages/SciplanPage";
import ProfilePage from "./pages/ProfilePage";

import './index.css'


import { BrowserRouter as Router, Routes, Route, Navigate } from "react-router-dom";
import { useState } from "react";

// ป้องกันต้องล็อกอินก่อนเข้าหน้าต่างๆ
const ProtectedRoute = ({ authUser, children }) => {
  return authUser ? children : <Navigate to="/login" />;
};

function App() {
  const [authUser, setAuthUser] = useState(null);

  const handleLogout = () => {
    setAuthUser(null);
  };
  
  return (
    <Router>

      <Header authUser={authUser} />

      <main className="pt-16">
        <Routes>
          <Route path="/" element={authUser ? <Navigate to="/home" /> : <LoginPage setAuthUser={setAuthUser} />} />
          <Route path="/login" element={<LoginPage setAuthUser={setAuthUser} />} />
          <Route path="/signup" element={<SignupPage setAuthUser={setAuthUser} />} />

          <Route path="/home" element={<ProtectedRoute authUser={authUser}><GeminiHome authUser={authUser} /></ProtectedRoute>} />
          <Route path="/profile" element={<ProtectedRoute authUser={authUser}><ProfilePage authUser={authUser} setAuthUser={setAuthUser} /></ProtectedRoute>} />
          <Route path="/observation" element={<ProtectedRoute authUser={authUser}><ObservePage authUser={authUser} /></ProtectedRoute>} />
          <Route path="/astrodata" element={<ProtectedRoute authUser={authUser}><AstroPage authUser={authUser} /></ProtectedRoute>} />
          <Route path="/sciplan" element={<ProtectedRoute authUser={authUser}><SciplanPage authUser={authUser} /></ProtectedRoute>} />

          <Route path="/logout" element={<LoginPage setAuthUser={handleLogout} />} />
        </Routes>
      </main>
    </Router>
  );
}

export default App;


