import React, {useState, useEffect} from "react";
import ListGroup from 'react-bootstrap/ListGroup';
import axios from "axios";

/* react-query 사용법
        https://musma.github.io/2023/09/14/react-query.html
    */

interface FriendBirthday {
    name: string;
    birthday: string;
}

function FriendList() {
    //임시 데이터
    const [friends, setFriends] = useState<FriendBirthday[]>([]);
    const [temp, setTemp] = useState([]);

    const handleFriendClick = (event: React.MouseEvent) => {
        const index = (event.target as HTMLElement).dataset.index;
        if (index !== undefined) {
            alert(`친구 상세정보 페이지로 이동: ${friends[Number(index)].name}`);
        }
    }

    const myEmail: string | null = localStorage.getItem("userEmail");

    useEffect(() => {
        getFriendList(myEmail);
    }, []);

    const getFriendList = async (email: string | null) => {

        try {
            const response = await axios.get(`/member/showFriends?email=${email}`);
            setFriends(response.data);
        } catch (error) {
            console.error("친구 불러오기 에러: " +error)
        }

    }


    return (
        <div>
            <h1>친구목록</h1>
            <ListGroup>
                {friends.map((friend, index) => (
                    <ListGroup.Item action key={index} data-index={index} onClick={handleFriendClick}>
                        {friend.name} {friend.birthday}
                    </ListGroup.Item>
                ))}
            </ListGroup>
        </div>
    );
}

export default FriendList;