import React from 'react'
import './styles/Input.css';
const Input = () => {
  return (
    <div>
      <form action="">
       <div className="input_box">
                <input type="username" placeholder="@Username"/>
                <input type="email" placeholder="University Email Address"/>
                <input type="password" placeholder="Password" className="Password"/>
                <input type="password" placeholder="Confirm Password"/>
        </div>
      </form>
    </div>
  );
}

export default Input
