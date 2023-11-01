import React from 'react';
import Navigation from '../atoms/Navigation';
import Input from '../atoms/Input';
import Label from '../atoms/Label';

interface RFProps {
    className: string
    wrapperClassName?: string
}

export const RememberForgot = (props: RFProps) => {
    return (
        <div>
            <div className={props.className}>
                <div className={props.wrapperClassName}>
                <Input type='checkbox'/>
                <Label htmlFor='checkbox' text='Remember me!'/>
                </div>
                <Navigation text='Forgot password?'/>
            </div>
        </div>
    );
};

export default RememberForgot;