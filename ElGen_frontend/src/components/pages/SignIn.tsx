import React, { useState } from 'react';
import Header from '../atoms/Header';
import Input from '../atoms/Input';
import Button from '../atoms/Button';
import RememberForgot from '../moleculs/RememberForgot';
import './styles/SignIn.css';
import HaveAccount from '../moleculs/HaveAccount';
import PasswordInput from '../moleculs/PasswordInput';
import EyeClosed from '../../assets/EyeClosed';
import EyeOpened from '../../assets/EyeOpened';
import { Link, Route, Routes } from 'react-router-dom';

const SignIn = () => {

    const [email, setUsername] = useState('');
    const [password, setPassword] = useState('');
    const [loginAttempts, setLoginAttempts] = useState(0);
    const handleSignIn = () => {
        // Отправляем GET-запрос на сервер, чтобы получить пароль по email
        fetch(`http://localhost:6868/users/email/${email}`)
            .then(response => {
                if (!response.ok) {
                    throw new Error('Failed to fetch password');
                }
                return response.json();
            })
            .then(data => {
                const correctPassword = data[0].password;
                if (password === correctPassword) {
                    // Сбросить счетчик при успешном входе
                    setLoginAttempts(0);
                    alert('Вход выполнен успешно');
                } else {
                    // Увеличить счетчик при неправильном вводе пароля
                    setLoginAttempts(prevAttempts => {
                        alert(`Неверный пароль.`);
                        // alert(`Неверный пароль. Попытка: ${prevAttempts + 1}`);
                        return prevAttempts + 1;
                    });
                }
            })
            .catch(error => {
                console.error('Ошибка:', error);
                alert('Произошла ошибка при входе');
            });
    };

    const handleUsernameChange = (e: React.ChangeEvent<HTMLInputElement>) => {
        setUsername(e.target.value);
    };

    const handlePasswordChange = (e: React.ChangeEvent<HTMLInputElement>) => {
        setPassword(e.target.value);
    };

    return (
        <div className='sign-in'>
            <Header header='Welcome Back!' subheader='Please sign up your account' />
            <form action='' className='input-box'>
                <Input type='username' placeholder='E-mail' inputName='text-input' id='username' onChange={handleUsernameChange} />
                <PasswordInput autoComplete='on' placeholder='Password' inputName='text-input' type='password' id='password-input' onChange={handlePasswordChange} />


                <RememberForgot className='remember-forgot' wrapperClassName='remember-forgot-wrapper' />
                <Button btnName='continue-btn' text='Sign In' id='signin-btn' onClick={handleSignIn} />
                <HaveAccount text="Don't have an account?" className='create-account' action='signUp' />
            </form>
        </div>
    );
};

export default SignIn;
