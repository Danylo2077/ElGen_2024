import React from 'react';
import Header_avatar from '../atoms/header_avatar'; // Проверьте правильный путь к компоненту Header_avatar
import LogoutButton from '../atoms/header_logout_button'; // Проверьте правильный путь к компоненту LogoutButton


const Header = () => {
    return (
        <header className="header">
            <Header_avatar src="post_author_avatar.png" />
            <LogoutButton />
        </header>
    );
}

export default Header;
