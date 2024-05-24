import React from "react";
import Button from "../atoms/Button";

interface PostControllPanelProps {
    
}

export const PostControllPanel = (props:PostControllPanelProps) => {
    return (
        <div className="postcontrol-container">
                <div className="nav-container"><Button btnName='postcontrol-btn' text='Global'/></div>
                <div className="nav-container"><Button btnName='postcontrol-btn' text='By Topics'/> </div>
                <div className="nav-container"><Button btnName='postcontrol-btn' text='Following'/> </div>
            <div className="new-post">
                 <Button btnName="new-post-btn" text="Add a new post +"/>
            </div>
        </div>
    )
}

export default PostControllPanel;