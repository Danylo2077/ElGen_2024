import React from 'react';

interface BtnProps {
    text: string;
    btnName: string;
    id: string;
    onClick?: () => void;
    className?: string;
}

export const Button: React.FC<BtnProps> = ({ btnName, text, id, onClick }) => {

    const handleClick = (e: React.MouseEvent<HTMLButtonElement>) => {
        e.preventDefault(); // Предотвращаем перезагрузку страницы
        if (onClick) {
            onClick(); // Вызываем обработчик события onClick, если он был передан
        }
    };

    return (
        <div>
            <form action="">
                <button type="button" id={id} className={btnName} onClick={onClick}>{text}</button>
            </form>
        </div>
    );
};

export default Button;

