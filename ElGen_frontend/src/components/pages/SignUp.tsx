import React, {useState} from 'react';
import Header from '../atoms/Header';
import Input from '../atoms/Input';
import Button from '../atoms/Button';
import HaveAccount from '../moleculs/HaveAccount';
import PasswordInput from '../moleculs/PasswordInput';
import './styles/SignUp.css';
import {Link} from "react-router-dom";



const SignUp = () => {
    const handleSignUp = () => {
        console.log('Регистрация пользователя...');
        // Здесь можно выполнить другие действия, связанные с регистрацией пользователя
    };
    const [passwordsMatch, setPasswordsMatch] = useState(true); // Используйте состояние для отслеживания совпадения паролей
    const [passwordCorrect, setPasswordCorrect] = useState(true); // Используйте состояние для отслеживания совпадения паролей

    const handlePasswordConfirmChange = () => {
        const passwordInput = document.getElementById("password-input") as HTMLInputElement;
        const passwordConfirmInput = document.getElementById("password-confirm") as HTMLInputElement;
        const passwordValue = passwordInput.value;
        const passwordConfirmValue = passwordConfirmInput.value;


        // Проверяем совпадение паролей при каждом изменении значения поля
        setPasswordsMatch(passwordConfirmValue === passwordValue);
    };

    const handlePasswordInputChange = () =>
    {
        const passwordInput = document.getElementById("password-input") as HTMLInputElement;
        const passwordValue = passwordInput.value;
        const passwordRegex = /^(?=.*[a-z])(?=.*[A-Z])(?=.*\d).{8,}$/;
        if (!passwordRegex.test(passwordValue)) {
            setPasswordCorrect(false)
        }
        else
        {setPasswordCorrect(true)}
    }



    const handleSignUpButtonClick = () =>
    {
        const usernameInput = document.getElementById("username") as HTMLInputElement;
       // const nameInput = document.getElementById("name") as HTMLInputElement;
        const emailInput = document.getElementById("email") as HTMLInputElement;
        const passwordInput = document.getElementById("password-input") as HTMLInputElement;
        const passwordConfirmInput = document.getElementById("password-confirm") as HTMLInputElement;

        const usernameValue = usernameInput.value;
        //const nameValue = nameInput.value;
        const emailValue = emailInput.value;
        const passwordValue = passwordInput.value;
        const passwordConfirmValue = passwordConfirmInput.value;


        if (!passwordsMatch || !passwordCorrect) {
            // Проверяем, что пароли совпадают и соответствуют требованиям
            return;
        }


        const userData = {
            username: usernameValue,
            //name: nameValue,
            password: passwordValue,
            email: emailValue
        };
        fetch('http://localhost:6868/api/auth/signup', {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json'
                // 'Authorization': `Bearer ${accessToken}`
            },
            body: JSON.stringify(userData)
        })
            .then(response => {
                if (!response.ok) {
                    throw new Error('Failed to create user');
                }
                return response.json();
            })
            .then(data => {
                alert('Пользователь успешно создан');
                console.log(data);
                localStorage.setItem('token', data.token);

                console.log("token "+data.token);
               window.location.href = '/SignIn';
                // Дополнительные действия после успешного создания пользователя
            })
            .catch(error => {
                console.error('Ошибка:', error);
                alert('Произошла ошибка при создании пользователя');
            });
    };



    return (


        <div className='sign-up'>
            <Header header='Welcome Back!' subheader='Please sign in to your account'/>
            <form className='input-box' onSubmit={(e) => e.preventDefault()}>
                <Input type='username' placeholder='@Username' inputName='text-input' id='username'/>
                {/*<Input type='name' placeholder='Enter your Name and Surname' inputName='text-input' id='name'/>*/}
                <Input type='email' placeholder='Enter your e-mail address' inputName='text-input' id='email'/>

                <PasswordInput autoComplete='on' placeholder='Password' type='password' inputName='text-input' id='password-input' onChange={handlePasswordInputChange}/>
                {/*{!passwordCorrect && <div className="error-message">Пароль должен содержать как минимум одну букву нижнего регистра, одну букву верхнего регистра, одну цифру и быть длиной не менее 8 символов</div>} /!* Отображаем сообщение об ошибке, если пароли не совпадают *!/*/}


                <PasswordInput autoComplete='on' placeholder='Confirm password' type='password' inputName='text-input' id='password-confirm' onChange={handlePasswordConfirmChange}/>
                {!passwordCorrect && <div className="error-message">Password must contain at least 8 chars, 1 capital letter and 1 special char</div>} {/* Отображаем сообщение об ошибке, если пароли не совпадают */}

                {!passwordsMatch && <div className="error-message">Password Dismatch</div>} {/* Отображаем сообщение об ошибке, если пароли не совпадают */}

                <HaveAccount text='Have An Account?' className='log-in' action='signIn'/>

                <Button btnName='continue-btn' text='Create Account' id='signup-btn' onClick={handleSignUpButtonClick}/>
            </form>
        </div>
    );
}

export default SignUp;
