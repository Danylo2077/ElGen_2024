// AddPostButton.jsx (Компонент кнопки "Add a New Post")
import React from 'react';

const AddPostButton = ({ text, className }) => {
    return (
        <button id="add_a_new_post_button" className={className}>{text}</button>
    );
}

export default AddPostButton;
