import React from 'react'

interface HeaderProps {
    header: string,
    subheader?:string,
  }
  
  export const Header = (props: HeaderProps) => {
    return (
      <div>
        <h1>{props.header}</h1>
        <h2>{props.subheader}</h2>
      </div>
    );
  }

export default Header
