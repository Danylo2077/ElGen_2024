import Button from "../atoms/Button";
import HomeIcon from "../../assets/Home";
import MessagesIcon from "../../assets/MessagesIcon";
import ProfileIcon from "../../assets/ProfileIcon";

import { Link } from 'react-router-dom';
import "./styles/Aside.css"

interface asideProps {
}

export const Aside = (props: asideProps) => {
    return (
        <div className="aside">
            <div className='btn-container'>
                <Link to="/MainPage">
                    <div className="nav-container"><HomeIcon/><span className="home-l"><Button id="aside-btn-home"
                                                                                               btnName='aside-btn'
                                                                                               text='Home'/></span>
                    </div>
                </Link>
                <Link to="/UserPage">
                    <div className="nav-container" id="profile-container"><ProfileIcon/><Button id="aside-btn-profile"
                                                                                                btnName='aside-btn'
                                                                                                text='Profile'/></div>
                </Link>
                <div className="nav-container"><MessagesIcon/><Button id="aside-btn-messages" btnName='aside-btn'
                                                                      text='Massages'/></div>
                 </div>
        </div>
    );
};

export default Aside;