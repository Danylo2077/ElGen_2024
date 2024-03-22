// ModalContent.jsx
import React from 'react';

const ModalContent = () => {
    return (
        <div className="modal-content" id="modal-content">
            <span className="close" id="close-button">&times;</span>
            <input type="text" id="new_post_input" name="new_post_input" placeholder="Write smt !" />
            <div className="hashtags_container" id="hashtags_container"></div>
            <div id="image-container">
                <img id="selected-image" src="" alt="Selected Image" />
            </div>
        </div>
    );
}

export default ModalContent;
