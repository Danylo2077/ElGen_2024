// PostImage.jsx
import React from 'react';

const PostImage = ({ src }) => {
    return (
        <img src={src} alt="Post Image" className="post_img" />
    );
}

export default PostImage;
