import React from 'react';
import Icon from '../atoms/Icon';
import Title from '../atoms/Title';

interface IconBlockProps {
    iconName: string,
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
                {/* <Icon iconSource={props.iconSource}/> */}
                <div className='tagIcon'></div>
                <Title text={props.text} titleName={props.titleName}/>
            </div>
        </div>
    );
};

export default IconBlock;