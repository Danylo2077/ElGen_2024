import React from 'react'

interface InputProps {
    id?: string
    placeholder?: string
    type: string
    name?: string
    ref?: string
    inputName?: string
    autoComplete?: 'on' | 'off'
    chekcedValue?: string
}

export const Input = (props: InputProps) =>  {
    return (
        <div>
            <form action="">
                <input autoComplete={props.autoComplete} type={props.type} placeholder={props.placeholder} name={props.name} ref={props.ref} className={props.inputName} id={props.id}/>
            </form>
        </div>
    );
}

export default Input
