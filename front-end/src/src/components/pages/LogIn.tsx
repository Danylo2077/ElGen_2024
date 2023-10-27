import React from 'react'
import Header from '../atoms/Header';
import Input from '../atoms/Input';
import Button from '../atoms/Button';
import RememberForgot from '../moleculs/RememberForgot';
import './styles/LogIn.css'
import HaveAccount from '../moleculs/HaveAccount';
const LogIn = () => {
  return (
    <>
      <Header header='Welcome Back!' subheader='Please sign in to your account'/>
      <form action="" className='input-box'>
      <Input type='username' placeholder='@Username'/>
      <Input type='password' placeholder='Password'/>
      <RememberForgot className='remember-forgot' wrapperClassName='remember-forgot-wrapper'/>
      <Button text='Sign In'/>
      <HaveAccount text='Don`t have an account?' navigate='Sign Up' className='create-account'/>
      </form>
    </>
  );
}

export default LogIn
