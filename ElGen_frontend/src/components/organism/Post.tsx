import React from "react"
import Profile from "../moleculs/Profile";
import Icon from "../atoms/Icon";
import LikeIcon from "../../assets/Like";
import ShareIcon from "../../assets/Share";
import SeenIcon from "../../assets/Seen";
import CommentIcon from "../../assets/Comment"
export const Post = () => {
    return (
        <div className="post">
        <Profile/>
        <div className="post-body"></div>
        <div className="interaction-container">
            <div className="interaction-subcontainer"><LikeIcon/><span className="like">0</span></div>
            <div className="interaction-subcontainer"><ShareIcon/><span className="share"></span></div>
            <div className="interaction-subcontainer"><SeenIcon/><span className="seen"></span></div>
            <div className="interaction-subcontainer"><CommentIcon/><span className="comment"></span></div>
        </div>
        </div>
    )
}

export default Post;