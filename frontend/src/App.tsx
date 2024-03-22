import React from 'react';
import logo from './logo.svg';
import './App.css';
import MainPage from "./pages/main_page";
import SignIn from "./pages/SignIn";
import SignUp from "./pages/SignUp";
import UserPreferences from "./pages/UserPreferences";
import { BrowserRouter as Router, Route, Routes } from 'react-router-dom'

function App() {

    return (
        <Router>
            <Routes>
                <Route path='/' element={<SignIn />} />
                <Route path='/SignUp' element={<SignUp />} />
                <Route path='/Preferences' element={<UserPreferences />} />
                <Route path='/MainPage' element={<MainPage />} />
            </Routes>
        </Router>
    );
}

export default App;
