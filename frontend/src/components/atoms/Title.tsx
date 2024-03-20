import React from 'react';

interface TitleProps {
    text: string
    titleName?: string
}

export const Title = (props: TitleProps) => {
    return (
        <div>
            <p className={props.titleName}>{props.text}</p>
        </div>
    );
};

export default Title;