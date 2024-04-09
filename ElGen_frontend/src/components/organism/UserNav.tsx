import Button from "../atoms/Button";
import Icon from "../atoms/Icon";
import Input from "../atoms/Input";
import {Link} from "react-router-dom";
interface usernavProps {
}

export const UserNav = (props: usernavProps) => {
    return (
        <div className="usernav">
            <div className='usernav-container'>
                <Link to="/SignIn"><Button btnName='usernav-btn' text='Log Out' id="add_a_new_post_button"/> </Link>
            </div>
        </div>
    );
};

export default UserNav;