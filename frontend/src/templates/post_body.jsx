// PostBody.jsx
import React from 'react';
import Avatar from '../atoms/post_author_avatar';
import Hashtags from '../atoms/post_hashtags';
import PostDescription from '../atoms/post_description';
import PostImage from '../atoms/post_image';
import Counter from '../molecules/post_counters';

const PostBody = () => {
    const hashtags = ["#Animals", "#Dogs", "#Cute"]; // Пример хэштегов

    return (
        <div className="post_body" id="post_body">
            <Avatar src="post_author_avatar.png" />
            <div className="post_author_nickname">Juri Dalkin</div>
            <Hashtags tags={hashtags} />
            <PostDescription text="When you trying to be a tough dog, but you actually just look like cute mashed potato XDD" />
            <PostImage src="post_img.png" />
            <Counter src="like_unliked_icon.png" count={188} />
            <Counter src="repost_icon.png" count={25} />
            <Counter src="views_icon.png" count={342} />
        </div>
    );
}

export default PostBody;
