import React from 'react'
import Header from '../atoms/Header';
import Input from '../atoms/Input';
import Button from '../atoms/Button';
import RememberForgot from '../moleculs/RememberForgot';
import HaveAccount from '../moleculs/HaveAccount';
import './styles/SignUp.css'


const SignUp = () => {
  return (
    <>
      <Header header='Welcome Back!' subheader='Please sign in to your account'/>
      <form action="" className='input-box'>
      <Input type='username' placeholder='@Username'/>
      <Input type='email' placeholder='University Email Address'/>
      <Input type='password' placeholder='Password'/>
      <Input type='password' placeholder='Confirm Password'/>
      <HaveAccount text='Have An Account?' navigate='Log In' className='log-in'/>
      <Button text='Create Account'/>
      </form>
    </>
  );
}

export default SignUp
