import React, { useState } from 'react'
import Header from '../atoms/Header';
import Input from '../atoms/Input';
import Button from '../atoms/Button';
import RememberForgot from '../moleculs/RememberForgot';
import './styles/SignIn.css'
import HaveAccount from '../moleculs/HaveAccount';
import PasswordInput from '../moleculs/PasswordInput';
import EyeClosed from '../../assets/EyeClosed';
import EyeOpened from '../../assets/EyeOpened'
import { Link, Route, Routes } from 'react-router-dom'
const SignIn = () => {
  return (
    <div className='sign-in'>
      <Header header='Welcome Back!' subheader='Please sign in to your account'/>
      <form action="" className='input-box'>
      <Input  type='username' placeholder='@Username' inputName='text-input' id='username'/>
      <PasswordInput autoComplete='on' placeholder='Password' inputName='text-input' id='password'/> 
      <RememberForgot className='remember-forgot' wrapperClassName='remember-forgot-wrapper'/>
      <Button btnName='continue-btn' text='Sign In'/>
      <HaveAccount text='Don`t have an account?' className='create-account' action='signUp'/>
      </form>
    </div>
  );
}

export default SignIn
