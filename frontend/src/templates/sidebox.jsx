// SideBox.jsx
import React from 'react';
import SideBoxHeader from '../atoms/sidebox_header';
import SideBoxBody from '../organims/sidebox_body';
import SideBoxFooter from '../atoms/sidebox_footer';

const SideBox = () => {
    return (
        <div className="sidebox" id="sidebox">
            <SideBoxHeader />
            <SideBoxBody />
            <SideBoxFooter />
        </div>
    );
}

export default SideBox;
