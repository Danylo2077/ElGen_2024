import React, { useState, useEffect, useRef } from 'react';
import { useParams } from 'react-router-dom';
import Icon from '../atoms/Icon';
import Link from '../atoms/Link';
import Post from './Post';
import Button from '../atoms/Button';
import {saveTokenToLocalStorage} from "../../scripts/SaveToken";

import axios from 'axios';


interface userInfoProps {
    username?: string;
    userTag?: string;
}
const UserInfo: React.FC<userInfoProps> = (props: userInfoProps) => {


    const token = localStorage.getItem('token');
    // const { username } = useParams<{ username: string }>();
    const [username, setUsername] = useState('YELISEI');
    //const [usernameState, setUsername] = useState(username || '');
    const [userTag, setUserTag] = useState('tester123');
    const [isEditing, setIsEditing] = useState(false);
    const oldUsername = useRef<string>(username || '');
    const oldUserTag = useRef<string>(userTag);

    // useEffect(() => {
    //     // Робимо запит до сервера при завантаженні компоненту
    //     axios.get(`http://localhost:6868/api/user/get/name/${username}`) // Припустимо, що це URL, за яким слухає сервер
    //         .then(response => {
    //             const userData = response.data;
    //             setUsername(userData.name);
    //             setUserTag(userData.username);
    //         })
    //         .catch(error => {
    //             console.error('Error fetching user data:', error);
    //         });
    // }, []);

    // useEffect(() => {
    //     // Робимо запит до сервера при завантаженні компоненту
    //     axios.get(`http://localhost:6868/api/user/get/name/${username}`) // Припустимо, що це URL, за яким слухає сервер
    //         .then(response => {
    //             const userData = response.data;
    //             setUsername(userData.name);
    //             setUserTag(userData.username);
    //         })
    //         .catch(error => {
    //             console.error('Error fetching user data:', error);
    //         });
    // }, []);



    const handleEdit = () => {
        setIsEditing(true);
        console.log("handleEdit");
        console.log("oldUsername "+oldUsername.current);
        console.log("TOKEN: " + token);
    };

    const handleSave = () => {
        setIsEditing(false);
        console.log("handleSave");
        console.log('http://localhost:6868/api/user/put/name/${oldUsername.current}');
        console.log(`http://localhost:6868/api/user/put/name/${oldUsername.current}`);
        console.log({name: username});
        console.log(`Bearer ${token}`);


        fetch(`http://localhost:6868/api/user/put/name/YELISEI`, {
            method: 'PUT',
            headers: {
                // 'Content-Type': 'application/json',
                'Authorization': `Bearer ${token}`
            },
            body: JSON.stringify({ name: username })

        })

            .then(() => {
                console.log('Name updated successfully');
            })
            .catch(error => {
                console.error('Error updating name:', error);
                console.log('TOKEN: ' + token);
            });

        // Отправка PUT-запроса для обновления юзернейма
    //     axios.put(`http://localhost:6868/api/user/put/username/${oldUserTag.current}`, { username: userTag },
    //         {
    //             headers: {
    //         'Authorization': `Bearer ${token}`
    //         }
    //         })
    //         .then(() => {
    //             console.log('Username updated successfully');
    //         })
    //         .catch(error => {
    //             console.error('Error updating username:', error);
    //         });
    //
    //     oldUsername.current = username || '';
    //
    //     oldUserTag.current = userTag;
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
                        <input type="text" value={userTag} onChange={handleUserTagChange} className="usertag-input"/>
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
