import React from 'react'
import './styles/Input.css'
const Input = () => {
  return (
    <div>
      <form action="">
      <div className="input_box">
        <input type="username" placeholder="Username"/>
        <input type="password" placeholder="Password" className="Password"/>
        <div className = "remember-forgot">
          <div className="Remember">
            <input type="checkbox"/>
            <label htmlFor="checkbox">Remember me</label>
          </div>
          <a href=" ">Forgot password?</a>
        </div>
      </div>
      </form>
    </div>
  )
}

export default Input
