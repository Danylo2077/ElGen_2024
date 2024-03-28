import * as React from 'react';
import './App.css';
import SignIn from './components/pages/SignIn';
import SignUp from './components/pages/SignUp';
import UserPreferences from './components/pages/UserPreferences'
import { Route, Routes } from 'react-router-dom'

function App() {
  return (
    <Routes>
      <Route path='/' element={<SignIn/>}/>
      <Route path='/SignUp' element={<SignUp/>}/>
      <Route path='/Preferences' element={<UserPreferences/>}/>  
    </Routes>
  );
}

export default App;