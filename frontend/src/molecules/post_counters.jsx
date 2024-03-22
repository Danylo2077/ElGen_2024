// Counter.jsx
import React from 'react';

const Counter = ({ src, count }) => {
    return (
        <div>
            <img src={src} alt="Icon" className={`${src.split('.')[0]}_icon_png`} />
            <div className={`${src.split('.')[0]}_counter`}>{count}</div>
        </div>
    );
}

export default Counter;
