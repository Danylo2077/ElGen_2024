import React from 'react';
import Navigation from '../atoms/Navigation';
import Title from '../atoms/Title';

interface HaveAccountProps {
    text: string,
    navigate: string,
    className: string
}

export const HaveAccount = (props: HaveAccountProps) => {
    return (
        <div>
        <div className={props.className}>
            <Title text={props.text}/>
            <Navigation text={props.navigate}/>
        </div>
        </div>
    );
};

export default HaveAccount;