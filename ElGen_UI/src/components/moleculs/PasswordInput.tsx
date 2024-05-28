import React, { useState, ChangeEvent } from 'react';
import Input, { InputProps } from '../atoms/Input';
import EyeClosed from '../../assets/EyeClosed';
import EyeOpened from '../../assets/EyeOpened';

interface PasswordInputProps extends Omit<InputProps, 'type'> {
    placeholder: string;
    type: string; // Include type property here
    onChange?: (e: React.ChangeEvent<HTMLInputElement>) => void;
}

export const PasswordInput = (props: PasswordInputProps) => {
    const [visible, setVisible] = useState(false);

    const toggleVisibility = () => {
        setVisible(!visible);
    };

    return (
        <div className='passWrapper'>
            <Input
                autoComplete={props.autoComplete}
                type={visible ? 'text' : props.type} // Use props.type here
                placeholder={props.placeholder}
                inputName={props.inputName}
                id={props.id}
                onChange={props.onChange}
            />
            <i className='iconPass' onClick={toggleVisibility}>
                {visible ? <EyeOpened/> : <EyeClosed/>}
            </i>
        </div>
    );
};

export default PasswordInput;
