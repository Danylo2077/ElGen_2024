// export {};
//
// document.addEventListener("DOMContentLoaded", function() {
//     const button = document.getElementById("signup-btn");
//     const usernameInput = document.getElementById("username");
//     const emailInput = document.getElementById("email");
//     const passwordInput = document.getElementById("password-input");
//     const passwordConfirmInput = document.getElementById("password-confirm");
//
//     if (button) {
//
//         button.addEventListener("click", function() {
//             console.log('Clicked');
//             const usernameValue = (usernameInput as HTMLInputElement).value;
//             const emailValue = (emailInput as HTMLInputElement).value;
//             const passwordValue = (passwordInput as HTMLInputElement).value;
//             const passwordConfirmValue = (passwordConfirmInput as HTMLInputElement).value;
//
//             if (passwordValue !== passwordConfirmValue) {
//                 console.log('Пароль и подтверждение пароля не совпадают');
//                 //return; // Выход из функции, если пароли не совпадают
//             }
//
//             // Данные для отправки
//             const userData = {
//                 userName: usernameValue,
//                 email: emailValue,
//                 password: passwordValue
//             };
//
//             // Выполняйте fetch-запрос здесь
//             fetch('http://localhost:6868/users', {
//                 method: 'POST',
//                 headers: {
//                     'Content-Type': 'application/json'
//                 },
//                 body: JSON.stringify(userData)
//             })
//                 .then(response => response.json())
//                 .then(data => {
//                     console.log('Успех:', data);
//                     // Дополнительные действия после успешной отправки запроса
//                 })
//                 .catch((error) => {
//                     console.error('Ошибка:', error);
//                     // Обработка ошибок
//                 });
//         });
//     }
// });
//
//



// your-script.js

export function handleSignUp() {
    const button = document.getElementById("signup-btn");
    const usernameInput = document.getElementById("username");
    const emailInput = document.getElementById("email");
    const passwordInput = document.getElementById("password-input");
    const passwordConfirmInput = document.getElementById("password-confirm");

    if (button) {
        button.addEventListener("click", function() {
            console.log('Clicked');
            const usernameValue = (usernameInput as HTMLInputElement).value;
            const emailValue = (emailInput as HTMLInputElement).value;
            const passwordValue = (passwordInput as HTMLInputElement).value;
            const passwordConfirmValue = (passwordConfirmInput as HTMLInputElement).value;

            if (passwordValue !== passwordConfirmValue) {
                console.log('Пароль и подтверждение пароля не совпадают');
                //return; // Выход из функции, если пароли не совпадают
            }

            const userData = {
                userName: usernameValue,
                email: emailValue,
                password: passwordValue
            };

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
                })
                .catch((error) => {
                    console.error('Ошибка:', error);
                    alert('Произошла ошибка. Подробности смотрите в консоли разработчика.');
                });
        });
    }
}
