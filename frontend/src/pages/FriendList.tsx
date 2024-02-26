import React, {useState} from "react";
import ListGroup from 'react-bootstrap/ListGroup';
import axios from "axios";
import {useQuery} from "@tanstack/react-query";

interface FriendBirthday {
    name: string;
    birthday: string;
}

function FriendList() {
    //임시 데이터
    const [friends, setFriends] = useState<FriendBirthday[]>([
        {name: '김철수', birthday: '2021-01-01'},
        {name: '박영희', birthday: '2021-02-01'},
        {name: '이철수', birthday: '2021-03-01'},
    ]);

    const handleFriendClick = (event: React.MouseEvent) => {
        const index = (event.target as HTMLElement).dataset.index;
        if (index !== undefined) {
            alert(`친구 상세정보 페이지로 이동: ${friends[Number(index)].name}`);
        }
    }
    /* react-query 사용법
        https://musma.github.io/2023/09/14/react-query.html
    */
    const getFriendList = async (email: string | null): Promise<FriendBirthday[]> => {
        return fetch(`/member/showFriends?email=${email}`).then((response) => response.json());
    }
    const myEmail: string | null = localStorage.getItem("userEmail");
    const {data, isError, error, isLoading} = useQuery<FriendBirthday[], Error>({
        queryKey: ['friends'],
        queryFn: () => getFriendList(myEmail)
    });

    if (isLoading) {
        return <div>Loading...</div>;
    }

    if (isError) {
        return <div>Error: {error.message}</div>;
    }

    return (
        <div>
            <h1>친구목록</h1>
            <ListGroup>
                {data.map((friend, index) => (
                    <ListGroup.Item action key={index} data-index={index} onClick={handleFriendClick}>
                        {friend.name} {friend.birthday}
                    </ListGroup.Item>
                ))}
            </ListGroup>
        </div>
    );
}

export default FriendList;