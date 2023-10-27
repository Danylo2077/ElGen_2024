import React from 'react';

interface NavProps {
    text: string,
    navName?: string
}

export const Navigation = (props: NavProps) => {
    return (
        <div>
            <a className={props.navName}>{props.text}</a>
        </div>
    );
};

export default Navigation;