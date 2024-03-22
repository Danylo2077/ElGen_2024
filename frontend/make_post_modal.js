document.addEventListener("DOMContentLoaded", function() {
    var openModalButton = document.getElementById("add_a_new_post_button");
    var modal = document.getElementById("new_post_modal");
    var close = document.getElementsByClassName("close")[0];
    var sidebox = document.querySelector(".sidebox");
    var isSideboxHidden = false;

    openModalButton.onclick = function() {
        modal.style.display = "block";
        if (!isSideboxHidden && sidebox) {
            sidebox.style.display = "block";
        }
    }

    close.onclick = function() {
        modal.style.display = "none";
        if (sidebox) {
            sidebox.style.display = "block"; // Показываем сайдбокс снова при закрытии модального окна
        }
    }

    window.onclick = function(event) {
        if (sidebox && !modal.contains(event.target)) {
            sidebox.style.display = "none";
            isSideboxHidden = true;
        }
        if (event.target === modal) {
            modal.style.display = "none";
            if (sidebox) {
                sidebox.style.display = "block"; // Показываем сайдбокс снова при клике за пределами модального окна
            }
        }
    }
    // Добавляем обработчик для aside, чтобы предотвратить скрытие сайдбокса при нажатии внутри aside
    var aside = document.querySelector("aside");
    aside.onclick = function(event) {
        event.stopPropagation(); // Предотвращаем всплытие события
    }
    var header = document.querySelector("header");

    header.onclick = function(event) {
        event.stopPropagation(); // Предотвращаем всплытие события
    }
    var post_body = document.getElementById("post_body");
    post_body.onclick = function(event) {
        event.stopPropagation(); // Предотвращаем всплытие события
    }
});


document.getElementById('post_button').addEventListener('click', function(event) {
    event.preventDefault();

    var new_post_input = document.getElementById("new_post_input");
    const text = new_post_input.value;

    const messageData = {
        messageText: text
        // Другие поля сущности Message, если они есть
    };

    fetch('http://localhost:8080/api/messages', {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json'
        },
        body: JSON.stringify(messageData)
    })
        .then(response => {
            if (!response.ok) {
                throw new Error('Network response was not ok');
            }
            return response.json();
        })
        .then(data => {
            console.log('Создано новое сообщение:', data);
            // Обработка ответа от сервера
        })
        .catch(error => {
            console.error('Произошла ошибка при создании сообщения:', error);
            // Выводим сообщение об ошибке в консоль
        });




});