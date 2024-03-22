// ButtonWithLabel.jsx (Компонент кнопки с названием)
import React from 'react';
import Icon from '../atoms/aside_icon';

const ButtonWithLabel = ({ iconSrc, altText, labelText }) => {
    return (
        <div className="button">
            <Icon src={iconSrc} altText={altText} />
            <div className="label">{labelText}</div>
        </div>
    );
}

export default ButtonWithLabel;
