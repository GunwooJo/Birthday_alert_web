// @ts-nocheck
import React from "react";
import {useParams} from "react-router-dom";

function FriendDetail() {

    const {friendId} = useParams();
    return (
        <div>
            <h1>친구 상세페이지</h1>
            <div>{friendId}</div>
        </div>
    );
}

export default FriendDetail;