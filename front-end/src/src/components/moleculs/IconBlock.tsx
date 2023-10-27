import React from 'react';
import Icon from '../atoms/Icon';
import Title from '../atoms/Title';

interface IconBlockProps {
    iconName?: 'tagIcon' | 'profileIcon'
    wrapperName: string,
    iconSource: string,
    altName?: string,
    text: string,
    titleName?: string
}

export const IconBlock = (props: IconBlockProps) => {
    return (
        <div>
            <div className={props.wrapperName}>
                <Icon iconName={props.iconName} iconSource={props.iconSource}/>
                <Title text={props.text} titleName={props.titleName}/>
            </div>
        </div>
    );
};

export default IconBlock;