import UserRegister from "./pages/UserRegister";
import AddFriend from "./pages/AddFriend";
import {Route, Routes} from "react-router-dom";
function App() {
    return (
        <Routes>
            <Route path='/friend/addBirthday' element={<AddFriend/>} />
            <Route path='/user/register' element={<UserRegister/>} />
        </Routes>
    );
}

export default App;
