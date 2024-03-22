// MainComponent.jsx (Главный компонент страницы)
import React from 'react';
import Header from '../templates/header';
import Nav from '../templates/nav';
import SideBox from '../templates/sidebox';
import Aside from '../templates/aside';
import PostBody from '../templates/post_body';

const MainPage = () => {
    return (
        <div>
            <Header />
            <Nav />
            <div className="main-content">
                <SideBox />
                <PostBody />
                <Aside />
            </div>
            {/* Дополнительный код или компоненты, если необходимо */}
        </div>
    );
}

export default MainPage;
