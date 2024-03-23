import React, { useState } from 'react';
import Input from '../atoms/Input';
import EyeClosed from '../../assets/EyeClosed';
import EyeOpened from '../../assets/EyeOpened';

interface PasswordInputProps {
    id?: string
    autoComplete?: 'on' | 'off'
    placeholder: string
    inputName?: string
}

export const PasswordInput = (props:PasswordInputProps) => {
    const [visible, isVisible] = useState(false);
    const toggleVisibilty = () => {
        isVisible(!visible);
    }
    return (
        <>
        <div className='passWrapper'>
        <Input autoComplete={props.autoComplete} type={visible ? 'text' : 'password'} placeholder={props.placeholder} inputName={props.inputName} id={props.id}/>
        <i className='iconPass' onClick={toggleVisibilty}>
        {visible? <EyeOpened/> : <EyeClosed/>}
        </i>
        </div>
        </>
    );
}

export default PasswordInput;
  