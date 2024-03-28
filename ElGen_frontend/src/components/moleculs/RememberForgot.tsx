import React, { useState } from 'react';
import Input from '../atoms/Input';
import Label from '../atoms/Label';
import ForgotPassword from '../organism/ForgotPassword';
interface RFProps {
    className: string
    wrapperClassName?: string
}

export const RememberForgot = (props: RFProps) => {
    const [showForgotPassword, setShowForgotPassword] = useState(false);

    return (
        <div>
            <div className={props.className}>
                <div className={props.wrapperClassName}>
                    <Input type='checkbox'/>
                    <Label htmlFor='checkbox' text='Remember me!'/>
                </div>
                <div onClick={() => setShowForgotPassword(true)}>Forgot Password?</div>
            </div>
            {showForgotPassword && <ForgotPassword onClose={() => setShowForgotPassword(false)} />}
        </div>
    );
};

export default RememberForgot;
