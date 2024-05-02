import Button from "../atoms/Button";
import Icon from "../atoms/Icon";
import Input from "../atoms/Input";
import {Link} from "react-router-dom";



interface usernavProps {
}


function deleteCookie(name: string) {
    document.cookie = name + '=; expires=Thu, 01 Jan 1970 00:00:00 UTC; path=/;';
}

// Удаление куки с именем 'token'



const handleLogoutButton = () =>
{
            localStorage.removeItem('token'); // Удалить токен
            deleteCookie('token');
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