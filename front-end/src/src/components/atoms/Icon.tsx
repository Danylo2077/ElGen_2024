import React from 'react';
interface IconProps {
    iconName?: 'tagIcon' | 'profileIcon'
    iconSource: string,
    altName?: string
}

export const Icon = (props: IconProps) => {
    return (
        <div>
            <img src={props.iconSource} alt={props.altName} className={props.iconName} />
        </div>
    );
};

export default Icon;