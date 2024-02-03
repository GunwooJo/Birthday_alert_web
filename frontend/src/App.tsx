import UserRegister from "./pages/UserRegister";
import AddBirthday from "./pages/AddBirthday";
import {Route, Routes} from "react-router-dom";
function App() {
    return (
        <Routes>
            <Route path='/friend/addBirthday' element={<AddBirthday/>} />
            <Route path='/user/register' element={<UserRegister/>} />
        </Routes>
    );
}

export default App;
