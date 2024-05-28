import React, { useState, useEffect, useRef } from 'react';

import Icon from '../atoms/Icon';
import Link from '../atoms/Link';
import Post from './Post';
import Button from '../atoms/Button';

import EditProfileModal from "./SettingsModal";
import UserInfoHandling from './UserInfoHandling';



interface userInfoProps {
    username?: string;
    userTag?: string;
    name?: string;
}
const UserInfo: React.FC<userInfoProps> = (props: userInfoProps) => {





    const token = localStorage.getItem('token');
    // console.log("token "+token);
    const [userTag, setUserTag] = useState<string>(localStorage.getItem('username') || '');

    const [isEditing, setIsEditing] = useState(false);
    const [username, setUsername] = useState('You have no Name yet :(');
    const oldUsername = useRef<string>('');
    // const oldUserTag = useRef<string>('');
    const oldUserTag = useRef<string>(localStorage.getItem('username') || '');

    // oldUserTag.current=localStorage.getItem('username');
    const [selectedImage, setSelectedImage] = useState<File | null>(null);
    const [isModalOpen, setIsModalOpen] = useState(false);
    const [avatarUrl, setAvatarUrl] = useState<string | null>(null); // состояние для хранения URL аватара
    const [avatarBlob, setAvatarBlob] = useState<Blob | null>(null); // состояние для хранения Blob аватара





    useEffect(() => {
        console.log("use effect");
        const fetchData = async () =>
        {
            console.log("before if");
            console.log("old user tag", oldUserTag);
            console.log("token", token);
            if (!oldUserTag.current || !token) return;
            console.log("after if");
            try {
                // Получение данных пользователя
                const userDataResponse = await fetch(`http://localhost:8080/api/user/get/username/${oldUserTag.current}`, {
                    method: 'GET',
                    headers: {
                        'Content-Type': 'application/json',
                        'Authorization': `Bearer ${token}`
                    },
                });
                const userData = await userDataResponse.json();
                setUsername(userData.name || 'You have no Name yet :(');
                console.log("setusername");
                oldUsername.current = userData.name || 'You have no Name yet :(';
                localStorage.setItem("name", userData.name || 'You have no Name yet :(');
            } catch (error) {
                console.error('Error fetching user data:', error);
            }

            try {
                // Получение аватара пользователя
                const avatarResponse = await fetch(`http://localhost:8080/api/user/avatar/${oldUserTag.current}`, {
                    method: 'GET',
                    headers: {
                        'Authorization': `Bearer ${token}`
                    },
                });
                if (!avatarResponse.ok) {
                    throw new Error('Network response was not ok');
                }

                const blob = await avatarResponse.blob(); // Получаем данные в виде Blob
                setAvatarBlob(blob); // Устанавливаем Blob аватара в состояние

                const imgUrl = URL.createObjectURL(blob); // Создаем URL-адрес для Blob
                setAvatarUrl(imgUrl); // Устанавливаем URL аватара в состояние
                console.log("imgUrl: " + imgUrl);
            } catch (error) {
                console.error('Error fetching avatar:', error);
            }
        };

        fetchData();
    }, [oldUserTag.current, token]);





    const updateName = () => {
        console.log("username ", username);
        console.log("oldUsername.current ", oldUsername.current);
        if(username!==oldUsername.current)
        {
            return fetch(`http://localhost:8080/api/user/put/name/${oldUserTag.current}`, {
                method: 'PUT',
                headers: {
                    'Content-Type': 'application/json',
                    'Authorization': `Bearer ${token}`
                },
                body: JSON.stringify({name: username})
            })
                .then(() => {
                    console.log('Name updated successfully with ', username);
                })
                .catch(error => {
                    console.error('Error updating name:', error);
                });
        }
        else
            console.log("username===oldUserTag.current",username===oldUsername.current) ;
    };

    const updateUsername = () =>
    {
        // console.log("userTag ", userTag);
        // console.log("oldUserTag.current ", oldUserTag.current);
        if (userTag !== oldUserTag.current)
        {
            fetch(`http://localhost:8080/api/user/put/username/${oldUserTag.current}`, {
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
        else
            console.log("console.log(userTag == oldUserTag.current)",userTag == oldUserTag.current) ;
    }


    const handleEdit = () => {
        setIsEditing(true);
        // console.log("handleEdit");
        console.log("oldUsername "+oldUsername.current);
        // console.log("TOKEN: " + token);
    };

    const handleSave = async () => {
        setIsEditing(false);
        // console.log("handleSave");
        // console.log(`http://localhost:6868/api/user/put/name/${oldUserTag.current}`);

        await updateName(); // Ждем, пока обновление имени завершится
        updateUsername(); // Запускаем обновление имени пользователя
        oldUsername.current = username || '';
        oldUserTag.current = userTag;
        const processedTag = UserInfoHandling(oldUserTag);
        console.log(processedTag);


        // console.log("handleSave done");
    };


    const handleUsernameChange = (e: React.ChangeEvent<HTMLInputElement>) => {

        setUsername(e.target.value);
        // console.log("handleUsernameChange. oldUsername: " + oldUsername.current);
    };

    const handleUserTagChange = (e: React.ChangeEvent<HTMLInputElement>) => {

        setUserTag(e.target.value);
        // console.log("handleUserTagChange. oldUserTag: " + oldUserTag.current);
    };



    const handleSettingsButtonClick = () => {

        setIsModalOpen(true);
    };

    const handleCloseModal = () => {
        setIsModalOpen(false);
    };


    return (

        <div className="user-info">
            <div className="user-info-container">
                <div className="user-info-container-icon">
                    <Icon
                        iconSource={avatarBlob ? URL.createObjectURL(avatarBlob) : undefined}
                        className='icon'
                        altName="Selected Image"
                        id="avatar"
                        imageSize={avatarBlob ? "200px" : (selectedImage ? "201px" : "201px")}
                    />


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
                    <div className="open-modal-button">

                    <Button text="Show more" id="settings-btn" btnName="settings-btn" onClick={handleSettingsButtonClick}/>
                    {isModalOpen && (
                        <EditProfileModal
                            isOpen={isModalOpen}
                            onClose={handleCloseModal}
                        />
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