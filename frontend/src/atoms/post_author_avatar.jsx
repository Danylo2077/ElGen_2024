// Avatar.jsx
import React from 'react';

const Avatar = ({ src }) => {
    return (
        <img src={src} alt="Post Author Avatar" className="post_author_avatar" />
    );
}

export default Avatar;
