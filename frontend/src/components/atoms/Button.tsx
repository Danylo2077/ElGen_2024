import React from 'react'

interface BtnProps {
  text: string
  btnName: string
}

export const Button = (props: BtnProps) => {
  return (
    <div>
      <form action="">
        <button className={props.btnName}>{props.text}</button>
      </form>
    </div>
  );
}

export default Button
