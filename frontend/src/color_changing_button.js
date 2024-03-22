const selectedHashtagsContainer = document.getElementById('hashtags_container');
const saveButton = document.getElementById('modal2_save_button');

function copyStyles(sourceElement, targetElement)
{
    const computedStyles = getComputedStyle(sourceElement);
    Array.from(computedStyles).forEach((style) => {
        targetElement.style[style] = computedStyles[style];
    });
}

function initializeColorChangingButtons() {
    const colorChangingButtons = document.querySelectorAll('.modal2_hastag1');
    let selectedButtonsCount = 0;

    colorChangingButtons.forEach((button) => {
        button.addEventListener('click', () => {
            const currentColor = button.style.backgroundColor || getComputedStyle(button).backgroundColor;

            if (currentColor === 'rgb(72, 72, 78)' || currentColor === '#48484e') {
                if (selectedButtonsCount < 3) {
                    button.style.backgroundColor = '#6d9af2';
                    selectedButtonsCount++;

                    // Создаем новый элемент для выбранного хештега
                    const selectedHashtag = document.createElement('div');
                    selectedHashtag.textContent = button.textContent;
                    copyStyles(button, selectedHashtag);

                    // Устанавливаем максимальную ширину и высоту для копии
                    selectedHashtag.style.maxWidth = '110px';
                    selectedHashtag.style.maxHeight = '30px';
                    selectedHashtag.style.fontSize = '15px';
                    selectedHashtag.style.lineHeight = '27px';
                    selectedHashtag.style.marginRight = '5px';

                    // Изначально устанавливаем свойство display в none
                    selectedHashtag.style.display = 'none';

                    selectedHashtagsContainer.appendChild(selectedHashtag);
                } else {
                    alert('Можно выбрать не более 3 кнопок с цветом #6d9af2 одновременно.');
                }
            } else {
                button.style.backgroundColor = '#48484e';
                selectedButtonsCount--;

                // Удаляем элемент выбранного хештега при отмене выбора
                const selectedHashtags = selectedHashtagsContainer.querySelectorAll('div');
                let selectedHashtag;

                selectedHashtags.forEach((hashtag) => {
                    if (hashtag.textContent.includes(button.textContent)) {
                        selectedHashtag = hashtag;
                    }
                });

                if (selectedHashtag) {
                    selectedHashtagsContainer.removeChild(selectedHashtag);
                }
            }
        });
    });

    saveButton.addEventListener('click', () => {
        // При нажатии на кнопку сохранения, меняем свойство display на block
        selectedHashtagsContainer.childNodes.forEach((hashtag) => {
            hashtag.style.display = 'block';
        });
    });
}

initializeColorChangingButtons();
