import React, { useState } from 'react';
import Icon from '../atoms/Icon';
import Link from '../atoms/Link';
import Post from './Post';
import Button from '../atoms/Button';


interface userInfoProps {
}
const UserInfo: React.FC<userInfoProps> = (props: userInfoProps) => {
    const [username, setUsername] = useState('User');
    const [userTag, setUserTag] = useState('@user');
    const [isEditing, setIsEditing] = useState(false);

    const handleEdit = () => {
        setIsEditing(true);
    };

    const handleSave = () => {
        setIsEditing(false);
    };

    const handleUsernameChange = (e: React.ChangeEvent<HTMLInputElement>) => {
        setUsername(e.target.value);
    };

    const handleUserTagChange = (e: React.ChangeEvent<HTMLInputElement>) => {
        setUserTag(e.target.value);
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
                        <Link text={username} className="username"/>
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
