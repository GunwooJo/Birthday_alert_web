import UserRegister from "./pages/user/UserRegister";
import AddFriend from "./pages/friend/AddFriend";
import FriendList from "./pages/friend/FriendList";
import {Route, Routes} from "react-router-dom";
import UserLogin from "./pages/user/UserLogin";
import FriendDetail from "./pages/friend/FriendDetail";
import AddGift from "./pages/gift/AddGift";

function App() {
    return (
        <Routes>
            <Route path='/friend/addBirthday' element={<AddFriend/>} />
            <Route path='/friend/list' element={<FriendList/>} />
            <Route path='/friend/detail/:friendId' element={<FriendDetail/>} />
            <Route path='/user/register' element={<UserRegister/>} />
            <Route path='/user/login' element={<UserLogin/>} />
            <Route path='/gift/add' element={<AddGift/>} />
        </Routes>
    );
}

export default App;
