import React from 'react'
import Header from '../atoms/Header';
import Input from '../atoms/Input';
import Button from '../atoms/Button';
import RememberForgot from '../moleculs/RememberForgot';
import HaveAccount from '../moleculs/HaveAccount';
import PasswordInput from '../moleculs/PasswordInput';
import './styles/SignUp.css'

const SignUp = () => {
  return (
    <div className='sign-up'>
      <Header header='Welcome Back!' subheader='Please sign in to your account'/>
      <form className='input-box'>
      <Input type='username' placeholder='@Username' inputName='text-input' id='username'/>
      <Input type='email' placeholder='University Email Address' inputName='text-input' id='email'/>
      <PasswordInput autoComplete='on' placeholder='Password' inputName='text-input' id='password'/>
      <PasswordInput autoComplete='on' placeholder='Confirm password' inputName='text-input'/>
      <HaveAccount text='Have An Account?' className='log-in' action='signIn'/>
      <Button btnName='continue-btn' text='Create Account'/>
      </form>
    </div>
  );
}
<script src="registration.js"></script>
export default SignUp
