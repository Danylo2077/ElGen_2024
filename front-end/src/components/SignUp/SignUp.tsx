import React from 'react'
import Header from './SignUpHeader';
import Input from './SignUpInput';
import SubmitBtn from './SignUpSubmitBtn';
import SignUpRout from './SignUpRout';
import './styles/SignUp.css'
const LogIn = () => {
  return (
    <div>
      <Header/>
      <Input/>
      <SubmitBtn/>
      <SignUpRout/>
    </div>
  );
}

export default LogIn
