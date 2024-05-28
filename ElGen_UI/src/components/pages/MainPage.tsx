import React from 'react';
import Aside from '../organism/Aside';
import UserNav from '../organism/UserNav';
import Post from '../organism/Post';
import Recommendation from '../organism/Recommendation';
import PostControllPanel from '../moleculs/PostControllPanel';
import './styles/MainPage.css';



const MainPage = () => {
    localStorage.setItem('lastTab', '/MainPage');
    return (
        <div className='main-page'>
            <div className='background'></div>
            <UserNav/>
            <Aside/>
            <PostControllPanel/>
            <Post/>
            <Recommendation/>
            <script>  </script>
        </div>
    );
}

export default MainPage;