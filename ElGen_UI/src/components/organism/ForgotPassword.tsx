import React from 'react';
import Input from '../atoms/Input';
import Button from '../atoms/Button';
import PasswordInput from '../moleculs/PasswordInput';
import Close from '../../assets/Close';

interface ForgotPasswordProps {
    onClose?: () => void; // Prop for the close function
}

const ForgotPassword: React.FC<ForgotPasswordProps> = ({ onClose }) => {
    return (
        <div className='forgot-pass-window'>
            <div onClick={onClose}>
                <Close/>
            </div>
            <div className='email-wrapper'>
                <Input type='email' placeholder='Enter your email' inputName='forgot-input'/>
                <Button btnName='send-btn' text='Send Code'/>
            </div>
            <PasswordInput autoComplete='on' placeholder='New Password' inputName='forgot-input'/>
            <PasswordInput autoComplete='on' placeholder='Confirm Password' inputName='forgot-input'/>
            <Button btnName='forgot-btn' text='Apply'/>
        </div>
    );
};

export default ForgotPassword;
