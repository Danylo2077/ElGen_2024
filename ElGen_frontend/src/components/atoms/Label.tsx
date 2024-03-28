import React from 'react';

interface LabelProps {
    htmlFor: string,
    text: string
}

export const Label = (props: LabelProps) => {
    return (
        <div>
            <label htmlFor={props.htmlFor}>{props.text}</label>
        </div>
    );
};

export default Label;