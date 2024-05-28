import React from 'react';

interface BtnProps {
    text: string;
    btnName: string;
    id: string;
    onClick?: () => void;
}

export const Button: React.FC<BtnProps> = ({ btnName, text, id, onClick }) => {
    return (
        <div>
            <form action="">
                <button id={id} className={btnName} onClick={onClick}>{text}</button>
            </form>
        </div>
    );
};

export default Button;

