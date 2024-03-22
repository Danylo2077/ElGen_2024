// SideBoxBody.jsx
import React from 'react';
import UserCard from '../molecules/sidebox_usercard';

const SideBoxBody = () => {
    return (
        <div className="sidebox_body">
            <UserCard imgSrc="you_might_also_like_1.png" name="Adam Ellis" followText="Follow" className="you_might_also_like_1" />
            {/* Аналогично для других пользователей */}
            {/* <UserCard /> для you_might_also_like_2, you_might_also_like_3, you_might_also_like_4 */}
        </div>
    );
}

export default SideBoxBody;
