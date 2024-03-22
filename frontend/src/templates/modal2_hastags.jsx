import React from 'react';
import Modal2Header from '../atoms/modal2_hastags_header';
import Modal2Body from '../atoms/modal2_hashtags_body';
import Modal2Footer from '../atoms/modal2_hastags_footer';

const Modal2 = () => {
    return (
        <div id="modal2" className="modal">
            <div className="modal-content2" id="modal-content2">
                <Modal2Header />
                <Modal2Body />
                {/* Кнопки с хэштегами не являются дочерними элементами, можно использовать их прямо здесь */}
                <button className="modal2_hastag1" id="modal2_hastag1">#Animals</button>
                <button className = "modal2_hastag1" id="modal2_hastag2">#Hobbies</button>
                <button className = "modal2_hastag1" id="modal2_hastag3">#Pets</button>
                <button className = "modal2_hastag1" id="modal2_hastag4">#Anime</button>
                <button className = "modal2_hastag1" id="modal2_hastag5">#Gaming</button>
                <Modal2Footer />
                <span id="close-button2" className="close_button2">x</span>
            </div>
        </div>
    );
}

export default Modal2;
