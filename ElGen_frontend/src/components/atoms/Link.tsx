import React from 'react';

interface LinkProps {
    text: string
    className?: string
    href?: string
}

export const Link = (props: LinkProps) => {
    return (
        <div>
            <a href={props.href} className={props.className}>{props.text}</a>
        </div>
    );
};

export default Link;