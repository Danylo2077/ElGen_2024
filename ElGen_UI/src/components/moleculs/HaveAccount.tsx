import React from 'react';
import Title from '../atoms/Title';
import { Link, Route, Routes } from 'react-router-dom'

interface HaveAccountProps {
    text: string,
    className: string,
    action?: 'signIn' | 'signUp'
}

export const HaveAccount = (props: HaveAccountProps) => {
    return (
        <div>
            <div className={props.className}>
                <Title text={props.text}/>
                <Link to='/SignIn'>{props.action === 'signIn' && <div className='have-an-account-sign-in'>Sign In</div>}</Link>
                <Link to='/SignUp'>{props.action === 'signUp' && <div className='have-an-account-sign-up'>Sign Up</div>}</Link>
            </div>
        </div>
    );
};

export default HaveAccount;
