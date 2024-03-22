// ThreeDotsButton.jsx (Компонент кнопки "Three Dots")
import React from 'react';

const ThreeDotsButton = ({ text, className }) => {
    return (
        <button className={className}>{text}</button>
    );
}

export default ThreeDotsButton;
