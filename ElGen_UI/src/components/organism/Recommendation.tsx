import React from "react"
import Title from "../atoms/Title";
import Profile from "../moleculs/Profile"

export const Recommendation = () => {
    return (
        <div className="recommendation">
            <Title titleName="also-like" text="You might also like"/>
            <Profile/>
        </div>
    )
}

export default Recommendation;