// Nav.jsx (Основной компонент)
import React from 'react';
import Button from '../atoms/nav_button';
import FollowSection from '../molecules/nav_follow_section';
import AddPostButton from '../atoms/nav_add_post_button';
import ThreeDotsButton from '../atoms/nav_three_dots';

const Nav = () => {
    return (
        <nav>
            <Button text="Global" className="global" />
            <Button text="By topics" className="by_topics" />
            <FollowSection />
            <AddPostButton text="Add a New Post +" className="add_a_new_post" />
            <ThreeDotsButton text="..." className="three_dots" />
        </nav>
    );
}

export default Nav;
