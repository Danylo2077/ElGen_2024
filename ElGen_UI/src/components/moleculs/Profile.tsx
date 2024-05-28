import React from "react";
import Icon from "../atoms/Icon";
import Link from "../atoms/Link";

interface ProfileProps {
    
}

export const Profile = (props:ProfileProps) => {
    return (
        <div className="profile-container">
                <div className="profile-icon"><Icon/></div>
                <div className="username-container">
                <Link text="User" className="username"/>
                <Link text="@user" className="user-tag"/>
                </div>
        </div>
    )
}

export default Profile;