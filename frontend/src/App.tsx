import UserRegister from "./pages/UserRegister";
import AddFriend from "./pages/AddFriend";
import FriendList from "./pages/FriendList";
import {Route, Routes} from "react-router-dom";
function App() {
    return (
        <Routes>
            <Route path='/friend/addBirthday' element={<AddFriend/>} />
            <Route path='/friend/list' element={<FriendList/>} />
            <Route path='/user/register' element={<UserRegister/>} />
        </Routes>
    );
}

export default App;
