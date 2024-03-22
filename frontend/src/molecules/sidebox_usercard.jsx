// UserCard.jsx
import React from 'react';

const UserCard = ({ imgSrc, name, followText, className }) => {
    return (
        <div className={className}>
            <img src={imgSrc} alt="User" className={`sidebox_photo ${className}_photo`} />
            <div className={`${className}_name_surname`}>
                {name}
            </div>
            <button className={`${className}_follow-button`}>{followText}</button>
        </div>
    );
}

export default UserCard;
