// Hashtags.jsx
import React from 'react';

const Hashtags = ({ tags }) => {
    return (
        <div>
            {tags.map((tag, index) => (
                <div key={index} className={`hashtag_${index + 1}`}> {tag} </div>
            ))}
        </div>
    );
}

export default Hashtags;
