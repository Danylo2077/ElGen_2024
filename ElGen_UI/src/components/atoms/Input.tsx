import React from 'react';

export interface InputProps {
    autoComplete?: 'on' | 'off';
    type: string;
    placeholder?: string;
    inputName?: string;
    id?: string;
    name?: string;
    ref?: string;
    onChange?: (e: React.ChangeEvent<HTMLInputElement>) => void;
    chekcedValue?: string;
}

const Input: React.FC<InputProps> = (props) => {
    return (
        <input
            autoComplete={props.autoComplete}
            type={props.type}
            placeholder={props.placeholder}
            name={props.inputName}
            id={props.id}
            onChange={props.onChange}
            ref={props.ref}
            className={props.inputName}
        />
    );
};

export default Input;
