// ModalFooter.jsx
import React from 'react';

const ModalFooter = () => {
    return (
        <div className="modal_footer">
            <button className="post_button" id="post_button"> Post </button>
            <div className="modal_images">
                <img src="modal_img1.png" className="modal_img1" id="modal_img1" />
                <img src="modal_img2.png" className="modal_img2" id="modal_img2" />
                <img src="modal_img3.png" className="modal_img3" id="modal_img3" />
                <img src="modal_img4.png" className="modal_img4" id="modal_img4" />
            </div>
        </div>
    );
}

export default ModalFooter;
