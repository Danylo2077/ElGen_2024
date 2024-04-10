import * as React from 'react';
import './App.css';
import SignIn from './components/pages/SignIn';
import SignUp from './components/pages/SignUp';
import UserPreferences from './components/pages/UserPreferences'
import UserPage from "./components/pages/UserPage";
import MainPage from "./components/pages/MainPage";
import { Route, Routes } from 'react-router-dom'
import UserInfo from "./components/organism/UserInfo";
//check
function App() {
  return (
    <Routes>
        <Route path='/UserPage' element={<UserPage/>}/>
      <Route path='/SignIn' element={<SignIn/>}/>
        <Route path="/userinfo/:username" element={<UserInfo />} /> {/* Маршрут для UserInfo */}

        <Route path='/MainPage' element={<MainPage/>}/>
      <Route path='/SignUp' element={<SignUp/>}/>
      <Route path='/Preferences' element={<UserPreferences/>}/>  
    </Routes>
  );
}

export default App;