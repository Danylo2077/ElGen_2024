import React from 'react'

interface BtnProps {
  text: string
}

export const Button = (props: BtnProps) => {
  return (
    <div>
      <form action="">
        <button>{props.text}</button>
      </form>
    </div>
  );
}

export default Button
