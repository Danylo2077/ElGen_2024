import React from 'react';
import ModalHeader from '../atoms/modal_new_post_header';
import ModalContent from '../molecules/modal_new_post_content';
import ModalFooter from '../molecules/modal_new_post_footer';

const Modal = () => {
    return (
        <div id="modal" className="modal">
            <ModalHeader />
            <ModalContent />
            <ModalFooter />
        </div>
    );
}

export default Modal;
