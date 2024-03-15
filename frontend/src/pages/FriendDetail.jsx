// @ts-nocheck
import React, {useEffect, useState} from "react";
import {useParams} from "react-router-dom";
import axios from "axios";

function FriendDetail() {

    const {friendId} = useParams();
    const [friend, setFriend] = useState({});

    useEffect(() => {
        fetchFriendDetail();
    }, []);

    const fetchFriendDetail = async () => {
        try {
            const response = await axios.get(`/friend/getInfo`, {
                params: {
                    friendId
                }
            });
            setFriend(response.data);
        } catch (error) {
            alert('에러 발생!');
            console.error("친구정보 불러오기 에러: " + error);
        }
    }

    return (
        <div>
            <h1>친구 상세페이지</h1>
            <div>{friendId}</div>
            <div>이름: {friend.name}</div>
            <div>생일: {friend.birthday}</div>
        </div>
    );
}

export default FriendDetail;