import React from 'react';
import Header from '../atoms/Header';
import Input from '../atoms/Input';
import Button from '../atoms/Button';
import HaveAccount from '../moleculs/HaveAccount';
import PasswordInput from '../moleculs/PasswordInput';
import './styles/SignUp.css';

const SignUp = () => {
    const handleSignUp = () => {
        console.log('Регистрация пользователя...');
        // Здесь можно выполнить другие действия, связанные с регистрацией пользователя
    };

    const handleSignUpButtonClick = () => {
        const usernameInput = document.getElementById("username") as HTMLInputElement;
        const emailInput = document.getElementById("email") as HTMLInputElement;
        const passwordInput = document.getElementById("password-input") as HTMLInputElement;
        const passwordConfirmInput = document.getElementById("password-confirm") as HTMLInputElement;

        const usernameValue = usernameInput.value;
        const emailValue = emailInput.value;
        const passwordValue = passwordInput.value;
        const passwordConfirmValue = passwordConfirmInput.value;

        const passwordRegex = /^(?=.*[a-z])(?=.*[A-Z])(?=.*\d).{8,}$/;
        if (!passwordRegex.test(passwordValue)) {
            alert('Пароль должен содержать как минимум одну букву нижнего регистра, одну букву верхнего регистра, одну цифру и быть длиной не менее 8 символов');
            return;
        }

        if (passwordValue !== passwordConfirmValue) {
            alert('Пароль и подтверждение пароля не совпадают');
            return;
        }

        const userData = {
            userName: usernameValue,
            email: emailValue,
            password: passwordValue
        };
        // console.log("user data"+usernameValue+emailValue+passwordValue)
        fetch('http://localhost:6868/users', {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json'
            },
            body: JSON.stringify(userData)
        })
            .then(response => response.json())
            .then(data => {
                console.log('Успех:', data);
                // Дополнительные действия после успешной отправки запроса
            })
            .catch((error) => {
                console.error('Ошибка:', error);
                alert(error);
            });
    };

    return (
        <div className='sign-up'>
            <Header header='Welcome Back!' subheader='Please sign in to your account'/>
            <form className='input-box' onSubmit={(e) => e.preventDefault()}>
                <Input type='username' placeholder='@Username' inputName='text-input' id='username'/>
                <Input type='email' placeholder='University Email Address' inputName='text-input' id='email'/>
                <PasswordInput autoComplete='on' placeholder='Password' type='password' inputName='text-input' id='password-input'/>
                <PasswordInput autoComplete='on' placeholder='Confirm password' type='password' inputName='text-input' id='password-confirm'/>
                <HaveAccount text='Have An Account?' className='log-in' action='signIn'/>
                <Button btnName='continue-btn' text='Create Account' id='signup-btn' onClick={handleSignUpButtonClick}/>
            </form>
        </div>
    );
}

export default SignUp;
