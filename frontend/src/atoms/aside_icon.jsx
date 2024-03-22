// Icon.jsx (Компонент иконки)
import React from 'react';

const Icon = ({ src, altText }) => {
    return (
        <img src={src} alt={altText} className="icon" />
    );
}

export default Icon;
