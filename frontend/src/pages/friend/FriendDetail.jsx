// @ts-nocheck
import React, {useEffect, useState} from "react";
import {useParams} from "react-router-dom";
import axios from "axios";
import ListGroup from 'react-bootstrap/ListGroup';
import Button from 'react-bootstrap/Button';

function FriendDetail() {

    const {friendId} = useParams();
    const [friend, setFriend] = useState({});
    const [memberGetGift, setMemberGetGift] = useState([
        'Cras justo odio',
        'Cras justo odio',
        'Cras justo odio'
    ]);
    const [friendGetGift, setFriendGetGift] = useState([]);
    const [allGifts, setAllGifts] = useState([]);

    useEffect(() => {
        fetchFriendDetail();
    }, []);

    useEffect(() => {
        if(Object.keys(friend).length !== 0) {
            const fetchAllGifts = async () => {
                try {
                    const response = await axios.get(`/gift/list`, {
                        params: {
                            friendId
                        }
                    })
                    setAllGifts(response.data);
                    //gift_type별 분류.(memberGetGift와 friendGetGift로)

                } catch (error) {
                    alert('에러 발생!');
                    console.error("선물 불러오기 에러: " + error);
                }
            }
        }
    }, [friend])

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
            <div style={{
                display: 'flex',
                flexDirection: 'column',
                alignItems: 'center',
                justifyContent: 'center',
                height: '20vh'
            }}>
                <h3>{friend.name}님과의 추억</h3>
                <h4>생일: {friend.birthday}</h4>
            </div>

            <div style={{
                display: 'flex',
                justifyContent: 'space-around'
            }}>
                <div>
                    <h4 style={{textAlign: 'center'}}>받은 선물 목록</h4>
                    <ListGroup>
                        {memberGetGift.map((gift, idx)=>{
                            return (
                                <ListGroup.Item key={gift + idx}>{gift}</ListGroup.Item>
                            )
                        })}
                    </ListGroup>
                    <div style={{ display: 'flex', justifyContent: 'center' }}>
                        <Button variant="success">선물추가</Button>
                    </div>
                </div>

                <div>
                    <h4 style={{textAlign: 'center'}}>준 선물 목록</h4>
                    <ListGroup>
                        {friendGetGift.map((gift, idx) => {
                            return (
                                <ListGroup.Item key={gift + idx}>{gift}</ListGroup.Item>
                            )
                        })}
                    </ListGroup>
                    <div style={{display: 'flex', justifyContent: 'center'}}>
                        <Button variant="success">선물추가</Button>
                    </div>
                </div>
            </div>

        </div>
    );
}

export default FriendDetail;