import React, { useState, useEffect, useRef } from 'react';
import { useParams } from 'react-router-dom';
import Icon from '../atoms/Icon';
import Link from '../atoms/Link';
import Post from './Post';
import Button from '../atoms/Button';
import {saveTokenToLocalStorage} from "../../scripts/SaveToken";

import axios from 'axios';
import {wait} from "@testing-library/user-event/dist/utils";


interface userInfoProps {
    username?: string;
    userTag?: string;
    name?: string;
}
const UserInfo: React.FC<userInfoProps> = (props: userInfoProps) => {





    const token = localStorage.getItem('token');
    console.log("token "+token);
    const [userTag, setUserTag] = useState<string>(localStorage.getItem('username') || '');

    const [isEditing, setIsEditing] = useState(false);
    const [username, setUsername] = useState('You have no Name yet :(');
    const oldUsername = useRef<string>('');
    const oldUserTag = useRef<string>('');

    useEffect(() => {
        oldUserTag.current = userTag;
        oldUsername.current=username;
        // console.log("oldusertag.current "+oldUserTag.current);
        fetch(`http://localhost:6868/api/user/get/name/${oldUserTag.current}`, {
            method: 'GET',
            headers: {
                'Content-Type': 'application/json',
                'Authorization': `Bearer ${token}`
            },
        })

            .then(response => response.json())

            .then(data => {
                // console.log("get received ",data);
                if (data && data.name) {
                    console.log(data.name);
                    setUsername(data.name);
                } else {
                    console.log("get dont received data");
                    setUsername('You have no Name yet :(');
                }
            })
            .catch(error => {
                console.error('Error:', error);
            });
    },[]);

    const updateName = () => {
        console.log("username ", username);
        return fetch(`http://localhost:6868/api/user/put/name/${oldUserTag.current}`, {
            method: 'PUT',
            headers: {
                'Content-Type': 'application/json',
                'Authorization': `Bearer ${token}`
            },
            body: JSON.stringify({ name: username })
        })
            .then(() => {
                console.log('Name updated successfully with ', username);
            })
            .catch(error => {
                console.error('Error updating name:', error);
            });
    };

    const updateUsername = () =>
    {
        console.log("userTag ", userTag);
        console.log("oldUserTag.current ", oldUserTag.current);
        if (userTag !== oldUserTag.current) {
            fetch(`http://localhost:6868/api/user/put/username/${oldUserTag.current}`, {
                method: 'PUT',
                headers: {
                    'Content-Type': 'application/json',
                    'Authorization': `Bearer ${token}`
                },
                body: JSON.stringify({username: userTag})
            })
                .then(() => {
                    console.log('Username updated successfully with ' + userTag);
                    localStorage.removeItem('token');
                    alert("After change of username you need to sign in again");
                    window.location.href = '/SignIn';
                })
                .catch(error => {
                    console.error('Error updating username:', error);
                });
        }
        ;
    }








    // const oldUsername = useRef<string>(username || '');




    const handleEdit = () => {
        setIsEditing(true);
        console.log("handleEdit");
        console.log("oldUsername "+oldUsername.current);
        console.log("TOKEN: " + token);
    };

    const handleSave = async () => {
        setIsEditing(false);
        console.log("handleSave");
        console.log(`http://localhost:6868/api/user/put/name/${oldUserTag.current}`);

        await updateName(); // Ждем, пока обновление имени завершится
        updateUsername(); // Запускаем обновление имени пользователя
        oldUsername.current = username || '';
        oldUserTag.current = userTag;
        console.log("handleSave done");
    };


    const handleUsernameChange = (e: React.ChangeEvent<HTMLInputElement>) => {

        setUsername(e.target.value);
        console.log("handleUsernameChange. oldUsername: " + oldUsername.current);
    };

    const handleUserTagChange = (e: React.ChangeEvent<HTMLInputElement>) => {

        setUserTag(e.target.value);
        console.log("handleUserTagChange. oldUserTag: " + oldUserTag.current);
    };


    return (
        <div className="user-info">
            <div className="user-info-container">
                <div className="user-info-container-icon">
                    <Icon/>
                </div>
                <div className="username-container">
                    {isEditing ? (
                        <input type="text" value={username} onChange={handleUsernameChange} className="username-input"/>
                    ) : (
                        <Link text={username ? username : 'Default Username'} className="username"/>

                    )}
                    {isEditing ? (
                        <input type="text" value={userTag || ''} onChange={handleUserTagChange}
                               className="usertag-input"/>
                    ) : (
                        <Link text={"@" + userTag} className="user-tag"/>
                    )}

                    <div className="edit-save-buttons">
                        {isEditing && (
                            <Button text="Save" id="edit-info-btn" btnName="save-info-btn" onClick={handleSave}/>
                        )}
                        {!isEditing && (
                            <Button text="Edit" id="edit-info-btn" btnName="edit-info-btn" onClick={handleEdit}/>
                        )}
                    </div>
                </div>


            </div>
            <div className="recent-posts-container">
                <div className="recent-posts-1">
                    <Post/>
                </div>
                <div className="recent-posts-2">
                    <Post/>
                </div>
            </div>
        </div>
    );
};

export default UserInfo;