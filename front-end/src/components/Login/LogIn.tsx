import React from 'react'
import Header from './LoginHeader';
import Input from './LogInInput';
import SubmitBtn from './LoginSubmitBtn';
import LogInRout from './LogInRout';
import './styles/LogIn.css'
const LogIn = () => {
  return (
    <div>
      <Header/>
      <Input/>
      <SubmitBtn/>
      <LogInRout/>
    </div>
  );
}

export default LogIn
