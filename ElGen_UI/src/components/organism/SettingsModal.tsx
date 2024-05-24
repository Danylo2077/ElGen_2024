import React, { useEffect, useState } from 'react';
import "./styles/SettingsModal.css";
import "../pages/styles/UserPage.css";
import "./UserInfoHandling";
import Icon from '../atoms/Icon';

interface EditProfileModalProps {
    isOpen: boolean;
    onClose: () => void;
}

const EditProfileModal: React.FC<EditProfileModalProps> = ({ isOpen, onClose }) => {
    const [bio, setBio] = useState('');
    const [email, setEmail] = useState('');
    const [password, setPassword] = useState('');
    const [selectedImage, setSelectedImage] = useState<File | null>(null);
    const [isBioChanged, setIsBioChanged] = useState(false);
    const [isEmailChanged, setIsEmailChanged] = useState(false);
    const [isPasswordChanged, setIsPasswordChanged] = useState(false);
    const [isImageChanged, setIsImageChanged] = useState(false); // состояние для отслеживания изменения изображения
    const [avatarUrl, setAvatarUrl] = useState<string | null>(null); // состояние для хранения URL аватара

    const oldUserTag = localStorage.getItem('username');
    const token = localStorage.getItem('token');

    useEffect(() => {
        const fetchData = async () => {
            if (!oldUserTag || !token) return;

            try {
                // Получение данных пользователя
                const userDataResponse = await fetch(`http://localhost:8080/api/user/get/username/${oldUserTag}`, {
                    method: 'GET',
                    headers: {
                        'Content-Type': 'application/json',
                        'Authorization': `Bearer ${token}`
                    },
                });
                const userData = await userDataResponse.json();
                setBio(userData.bio || '');
                setEmail(userData.email || '');

                // Получение аватара пользователя
                const avatarResponse = await fetch(`http://localhost:8080/api/user/avatar/${oldUserTag}`, {
                    method: 'GET',
                    headers: {
                        'Authorization': `Bearer ${token}`
                    },
                });
                if (!avatarResponse.ok) {
                    throw new Error('Network response was not ok');
                }
                console.log(avatarResponse);
                const blob = await avatarResponse.blob(); // Получаем данные в виде Blob
                const imgUrl = URL.createObjectURL(blob); // Создаем URL-адрес для Blob
                setAvatarUrl(imgUrl); // Устанавливаем URL аватара в состояние
            } catch (error) {
                console.error('Error fetching user avatar:', error);
            }
        };

        fetchData();
    }, [oldUserTag, token]);

    const handleSubmit = async (e: React.FormEvent<HTMLFormElement>) => {
        e.preventDefault();
        try {
            if (isBioChanged) {
                await fetch(`http://localhost:8080/api/user/put/bio/${oldUserTag}`, {
                    method: 'PUT',
                    headers: {
                        'Content-Type': 'application/json',
                        'Authorization': `Bearer ${token}`
                    },
                    body: JSON.stringify({ bio: bio })
                });
                console.log('Bio updated successfully with ', bio);
            }

            if (isEmailChanged) {
                await fetch(`http://localhost:8080/api/user/put/email/${oldUserTag}`, {
                    method: 'PUT',
                    headers: {
                        'Content-Type': 'application/json',
                        'Authorization': `Bearer ${token}`
                    },
                    body: JSON.stringify({ email: email })
                });
                console.log('Email updated successfully with ', email);
            }

            if (isPasswordChanged) {
                await fetch(`http://localhost:8080/api/user/put/password/${oldUserTag}`, {
                    method: 'PUT',
                    headers: {
                        'Content-Type': 'application/json',
                        'Authorization': `Bearer ${token}`
                    },
                    body: JSON.stringify({ password: password })
                });
                console.log('Password updated successfully with ', password);
            }

            if (isImageChanged) {
                const formData = new FormData();
                formData.append('file', selectedImage!);

                try {
                    const response = await fetch(`http://localhost:8080/api/user/put/avatar/${oldUserTag}`, {
                        method: 'PUT',
                        headers: {
                            'Authorization': `Bearer ${token}`
                        },
                        body: formData
                    });

                    if (!response.ok) {
                        throw new Error('Failed to update avatar');
                    }

                    const data = await response.text();
                    console.log('Received data:', data);
                    console.log('Avatar updated successfully');
                } catch (error) {
                    console.error('Error updating avatar:', error);
                }
            }

            onClose();
        } catch (error) {
            console.error('Error updating bio, email, password, or avatar:', error);
        }
        window.location.reload();
    };

    const handleIconClick = () => {
        const input = document.createElement('input');
        input.type = 'file';
        input.accept = 'image/*';
        input.onchange = (event: Event) => {
            const target = event.target as HTMLInputElement;
            const files = target.files;
            if (files && files.length > 0) {
                const selectedFile = files[0];
                setSelectedImage(selectedFile);
                setAvatarUrl(URL.createObjectURL(selectedFile));
                setIsImageChanged(true); // устанавливаем состояние для отслеживания изменения изображения
            }
        };
        input.click();
    };

    return (
        <div className={`modal ${isOpen ? 'open' : ''}`}>
            <div className="modal-content">
                <span className="close" onClick={onClose}>&times;</span>
                <form onSubmit={handleSubmit}>
                    <div className="inputs">
                        <div className='icon-container' onClick={handleIconClick}>
                            <Icon
                                iconSource={avatarUrl ? avatarUrl : undefined}
                                className='icon'
                                altName="Selected Image"
                                id="avatar"
                                imageSize="100px"
                            />
                        </div>

                        <label>
                            Bio:
                            <input className='write-here' type="text" value={bio}
                                   onChange={(e) => { setBio(e.target.value); setIsBioChanged(true); }} />
                        </label>
                        <label>
                            Email:
                            <input className='write-here' type="email" value={email}
                                   onChange={(e) => { setEmail(e.target.value); setIsEmailChanged(true); }} />
                        </label>
                        <label>
                            Password:
                            <input className='write-here' type="text" value={password}
                                   onChange={(e) => { setPassword(e.target.value); setIsPasswordChanged(true); }} />
                        </label>

                        <button type="submit" id='modal-save-btn'>Save</button>
                    </div>
                </form>
            </div>
        </div>
    );
}

export default EditProfileModal;
