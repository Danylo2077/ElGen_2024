import React, {useState} from "react";
import Button from "../atoms/Button";
import NewPostModal from "../organism/NewPostModal";

interface PostControllPanelProps {

}

export const PostControllPanel = (props:PostControllPanelProps) => {

    const [showModal, setShowModal] = useState(false);

    const Nothing = () =>
    {

    }

    const handleOpenModal = () => {
        setShowModal(true);
    };

    const handleCloseModal = () => {
        setShowModal(false);
    };

    return (
        <div className="postcontrol-container">
                <div className="nav-container"><Button btnName='postcontrol-btn' id="global-btn" text='Global'/></div>
                <div className="nav-container"><Button btnName='postcontrol-btn' id="topics-btn" text='By Topics'/> </div>
                <div className="nav-container"><Button btnName='postcontrol-btn' id="following-btn" text='Following'/> </div>
            <div className="new-post">
                 <Button btnName="new-post-btn" id="new-post-btn" text="Add a new post +" onClick={handleOpenModal} />

            </div>
            <NewPostModal show={showModal}  onClose={handleCloseModal} onPhotoChange={Nothing} >

            </NewPostModal>
        </div>
    );
}

export default PostControllPanel;