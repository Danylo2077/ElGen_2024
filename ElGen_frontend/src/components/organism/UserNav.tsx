import Button from "../atoms/Button";
import Icon from "../atoms/Icon";
import Input from "../atoms/Input";
import {Link} from "react-router-dom";


interface usernavProps {
}


const handleLogoutButton = () =>
{
            localStorage.removeItem('token'); // Удалить токен


}

export const UserNav = (props: usernavProps) => {
    return (
        <div className="usernav">
            <div className='usernav-container'>
                <Link to="/SignIn"><Button btnName='usernav-btn' text='Log Out' id="logout-btn" onClick={handleLogoutButton}/> </Link>
            </div>
        </div>
    );
};

export default UserNav;