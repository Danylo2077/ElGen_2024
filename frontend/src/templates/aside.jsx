// Aside.jsx (Основной компонент)
import React from 'react';
import ButtonWithLabel from '../molecules/aside_button_with_label';

const Aside = () => {
    return (
        <aside>
            <div className="aside_main_text">MAIN</div>

            <ButtonWithLabel
                iconSrc="home_icon.png"
                altText="Home Icon"
                labelText="Home page"
            />

            <ButtonWithLabel
                iconSrc="profile_icon.png"
                altText="Profile Icon"
                labelText="Profile"
            />

            <ButtonWithLabel
                iconSrc="messages_icon.png"
                altText="Messages Icon"
                labelText="Messages"
            />
        </aside>
    );
}

export default Aside;
