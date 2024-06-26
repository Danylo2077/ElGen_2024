import React, { useState } from 'react';
import { useNavigate } from 'react-router-dom';
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
import {saveTokenToLocalStorage} from "../../scripts/SaveToken";


const SignIn = () => {
    localStorage.setItem('lastTab', '/SignIn');
    const [username, setUsername] = useState('');
    const [password, setPassword] = useState('');
    const navigate = useNavigate();

    const sendLastLogin = () => {
        const token = localStorage.getItem('token');
        const username = localStorage.getItem('username');
        const currentDate = new Date();

        // Получите дату и время отдельно
        // const date = currentDate.toISOString().split('T')[0]; // Получите дату в формате 'YYYY-MM-DD'
        // const time = currentDate.toISOString().split('T')[1].split('.')[0]; // Получите время в формате 'HH:MM:SS'

        // Объедините дату и время вместе
        // const lastLogin = `${date}T${time}`;
        const lastLogin = currentDate.toISOString();
        console.log(lastLogin);

        fetch(`http://localhost:8080/api/user/put/lastlogin/${username}`, {
            method: 'PUT',
            headers: {
                'Content-Type': 'application/json',
                'Authorization': `Bearer ${token}`
            },
            body: JSON.stringify({ lastLogin }) // Отправьте дату и время последнего входа
        })
            .then(response => {
                if (!response.ok) {
                    throw new Error('Failed to send last login time');
                }
                console.log('Last login time sent successfully', lastLogin);
            })
            .catch(error => {
                console.error('Error sending last login time:', error);
            });
    };


    const handleSignIn = () => {
        const token = localStorage.getItem('token');
        console.log("token "+token);
        fetch('http://localhost:8080/api/auth/signin', {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json'
            },
            body: JSON.stringify({ username, password })
        })
            .then(response => {
                if (!response.ok) {
                    throw new Error('Failed to login');
                }
                return response.json();
            })
            .then(data => {
                console.log('Received data:', data);

                localStorage.setItem('username', data.username);
                localStorage.setItem('user-id', data.id);
                localStorage.setItem('token', data.accessToken);
                localStorage.setItem('email', data.email);
                console.log("token "+token);
                saveTokenToLocalStorage(data.accessToken);

                sendLastLogin();



                // Перенаправляем на другую страницу
               window.location.href = '/MainPage';
               //  navigate(`/userinfo/${username}`);
            })
            .catch(error => {
                console.error('Ошибка:', error);
                alert(error);
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
                <Input type='username' placeholder='Username' inputName='text-input' id='username' onChange={handleUsernameChange} />
                <PasswordInput autoComplete='on' placeholder='Password' inputName='text-input' type='password' id='password-input' onChange={handlePasswordChange} />


                <RememberForgot className='remember-forgot' wrapperClassName='remember-forgot-wrapper' />
                <Button btnName='continue-btn' text='Sign In' id='signin-btn' onClick={handleSignIn} />
                <HaveAccount text="Don't have an account?" className='create-account' action='signUp' />
            </form>
        </div>
    );
};

export default SignIn;
