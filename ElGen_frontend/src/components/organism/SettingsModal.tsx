import React, {useEffect, useState} from 'react';
import "./styles/SettingsModal.css";
import "../pages/styles/UserPage.css";
import "./UserInfoHandling";
import UserInfoHandling from "./UserInfoHandling";
import {saveTokenToLocalStorage} from "../../scripts/SaveToken";


interface EditProfileModalProps {
    isOpen: boolean;
    onClose: () => void;
}
const EditProfileModal: React.FC<EditProfileModalProps> = ({ isOpen, onClose }) => {
    const [bio, setBio] = useState('');
    const [email, setEmail] = useState('');
    const [password, setPassword] = useState('');
    const oldUserTag = localStorage.getItem('username');
    const token = localStorage.getItem('token');


    useEffect(() => {
        const email = localStorage.getItem('email');
        console.log("email: ", email);
        setEmail(email || '');
        if (oldUserTag) {
            console.log("sending")
            // Получение текущих значений из базы данных
            fetch(`http://localhost:6868/api/user/get/username/${oldUserTag}`, {
                method: 'GET',
                headers: {
                    'Content-Type': 'application/json',
                    'Authorization': `Bearer ${token}`
                },
            })
                .then(response => response.json())
                .then(data => {
                    console.log(data);
                    setBio(data.bio || '');
                    setEmail(email || '');
                    // Можете также установить текущее значение для поля password, если оно доступно в ответе
                })
                .catch(error => {
                    console.error('Error fetching user data:', error);
                });
        }
    }, [oldUserTag, token]);


    console.log("USERTAG: ", oldUserTag);
    console.log("TOKEN: ", token);
    const handleSubmit = async (e: React.FormEvent<HTMLFormElement>) => {
        e.preventDefault();
        console.log("USERTAG: ", oldUserTag);
        console.log("TOKEN: ", token);

        try {
            await fetch(`http://localhost:6868/api/user/put/bio/${oldUserTag}`, {
                method: 'PUT',
                headers: {
                    'Content-Type': 'application/json',
                    'Authorization': `Bearer ${token}`
                },
                body: JSON.stringify({bio: bio})
            });
            console.log('Bio updated successfully with ', bio);

            await fetch(`http://localhost:6868/api/user/put/email/${oldUserTag}`, {
                method: 'PUT',
                headers: {
                    'Content-Type': 'application/json',
                    'Authorization': `Bearer ${token}`
                },
                body: JSON.stringify({email: email})
            });
            console.log('Email updated successfully with ', email);

            await fetch(`http://localhost:6868/api/user/put/password/${oldUserTag}`, {
                method: 'PUT',
                headers: {
                    'Content-Type': 'application/json',
                    'Authorization': `Bearer ${token}`
                },
                body: JSON.stringify({password: password})
            });
            console.log('password updated successfully with ', password);

            onClose();
        } catch (error) {
            console.error('Error updating bio or email:', error);
        }
    };


    return (
        <div className={`modal ${isOpen ? 'open' : ''}`}>
            <div className="modal-content">
                <span className="close" onClick={onClose}>&times;</span>
                <form onSubmit={handleSubmit}>
                    <div className="inputs">
                        <label>
                            Bio:
                            <input className='write-here' type="text" value={bio} onChange={(e) => setBio(e.target.value)}/>
                        </label>
                        <label>
                            Email:
                            <input className='write-here' type="email" value={email} onChange={(e) => setEmail(e.target.value)}/>
                        </label>
                        <label>
                            Password:
                            <input className='write-here' type="text" value={password} onChange={(e) => setPassword(e.target.value)}/>
                        </label>
                        <button type="submit" id='modal-save-btn'>Save</button>
                    </div>
                </form>
            </div>
        </div>
    );
}

    export default EditProfileModal;
