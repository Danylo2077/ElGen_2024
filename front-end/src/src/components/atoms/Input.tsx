import React from 'react'

interface InputProps {
    placeholder?: string,
    type: string,
}

export const Input = (props: InputProps) =>  {
    return (
        <div>
            <form action="">
                <input type={props.type} placeholder={props.placeholder}/>
            </form>
        </div>
    );
}

export default Input
