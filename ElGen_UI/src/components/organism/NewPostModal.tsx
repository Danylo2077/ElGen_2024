import React, { useState } from "react";
import "../organism/styles/NewPostModal.css";
import Button from "../atoms/Button"; // Add some basic styling

interface ModalProps {
    show?: boolean;
    onClose: () => void;
    children: any | null;
    onPhotoChange: (photo: File | null) => void; // Функция для передачи выбранного изображения в родительский компонент
}

const NewPostModal: React.FC<ModalProps> = ({ show, onClose, children, onPhotoChange }) => {
    const [description, setDescription] = useState("");
    const [hashtags, setHashtags] = useState("");
    const [photo, setPhoto] = useState<File | null>(null);
    const token = localStorage.getItem("token");

    if (!show) {
        return null;
    }

    const handleDescriptionChange = (e: React.ChangeEvent<HTMLTextAreaElement>) => {
        setDescription(e.target.value);
    };

    const handleHashtagsChange = (e: React.ChangeEvent<HTMLInputElement>) => {
        setHashtags(e.target.value);
    };

    const handlePhotoChange = (e: React.ChangeEvent<HTMLInputElement>) => {
        const file = e.target.files ? e.target.files[0] : null;
        setPhoto(file);
        onPhotoChange(file); // Передаем выбранное изображение в родительский компонент
    };

    const handlePost = async () => {
        console.log("Post", token);
        const formData = new FormData();

        formData.append('post', JSON.stringify({
            text: description,
            tags: hashtags.split(',').map(tag => ({ messageTagName: tag.trim() })),
            user: { userId: parseInt(localStorage.getItem('user-id')!) },
        }));

        if (photo) {
            console.log("Selected file:", photo.name);
            formData.append('files', photo!);
        }

        try {
            const response = await fetch('http://localhost:8080/posts/posts', {
                method: 'POST',
                headers: {
                    'Authorization': `Bearer ${token}`
                },
                body: formData
            });
            console.log("formData");
            const responseData = await response.json();

            if (response.ok) {
                console.log('Пост успешно создан', responseData);
                alert("Пост создан успешно");
                onClose();
                // Additional actions upon successful post creation
            } else {
                alert("Не удалось создать пост");
                console.error('Не удалось создать пост', responseData);
                // Additional actions upon unsuccessful post creation
            }
        } catch (error) {
            console.error('Ошибка при создании поста:', error);
        }
    };

    return (
        <div className="modal-overlay">
            <div className="modal-content">
                <button className="modal-close" onClick={onClose}>X</button>
                <h2>New Post</h2>
                <textarea
                    placeholder="Description"
                    value={description}
                    onChange={handleDescriptionChange}
                    className="modal-input"
                />
                <input
                    type="text"
                    placeholder="Hashtags"
                    value={hashtags}
                    onChange={handleHashtagsChange}
                    className="modal-input"
                />
                <label className="custom-file-upload">
                    <input
                        type="file"
                        accept="image/*"
                        onChange={handlePhotoChange}
                        className="file-input"
                    />
                    Choose Photo
                </label>
                {photo && (
                    <div className="photo-preview">
                        <img src={URL.createObjectURL(photo)} alt="Preview" />
                    </div>
                )}
                <Button text="Post" id="post-btn" btnName="settings-btn" onClick={handlePost}/>
            </div>
        </div>
    );
}

export default NewPostModal;
