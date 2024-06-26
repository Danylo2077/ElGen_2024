import React, { useState } from 'react';
import UserNav from "../organism/UserNav";
import Aside from "../organism/Aside";
import UserInfo from "../organism/UserInfo"
import './styles/UserPage.css';

const UserPage = () => {
    localStorage.setItem('lastTab', '/UserPage');

    // console.log("token "+token);
    return (
        <div className="user-page">
            <UserNav/>
            <Aside/>
            <UserInfo/>
        </div>
    )

};

export default UserPage;