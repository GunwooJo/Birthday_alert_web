// @ts-nocheck
import React, { useState } from 'react';
import { Form, Button, Container, Row, Col } from 'react-bootstrap';
import axios from "axios";
import {useNavigate, useParams} from "react-router-dom";

const AddGift = () => {
    const [giftInfo, setGiftInfo] = useState({
        name: '',
        date: '',
        gift_type: '',
        content: '',
    });
    const isFormFilled = giftInfo.name && giftInfo.date && giftInfo.gift_type && giftInfo.content;
    const navigate = useNavigate();
    const {friendId} = useParams();

    const handleChange = (e) => {
        const { name, value } = e.target;
        setGiftInfo({ ...giftInfo, [name]: value });
    };

    const handleSubmit = async (e) => {
        e.preventDefault();
        if(!isFormFilled) {
            alert('모든 항목을 입력해주세요!');
            return;
        }

        try {
            const response = await axios.post(`/gift/add/${friendId}`, giftInfo)
            navigate(`/friend/detail/${friendId}`);
        } catch (error) {
            console.error(error);
            alert('오류가 발생했어요.');
        }

    };

    return (
        <Container className="mt-5">
            <Form onSubmit={handleSubmit}>
                <Row>
                    <Col md={6}>
                        <Form.Group className="mb-3">
                            <Form.Label>선물 이름:</Form.Label>
                            <Form.Control
                                type="text"
                                name="name"
                                value={giftInfo.name}
                                onChange={handleChange}
                                placeholder="선물 이름을 입력하세요"
                            />
                        </Form.Group>
                    </Col>
                    <Col md={6}>
                        <Form.Group className="mb-3">
                            <Form.Label>날짜:</Form.Label>
                            <Form.Control
                                type="date"
                                name="date"
                                value={giftInfo.date}
                                onChange={handleChange}
                            />
                        </Form.Group>
                    </Col>
                </Row>
                <Row>
                    <Col md={12}>
                        <Form.Check
                            inline
                            label="받은 선물"
                            name="gift_type"
                            type="radio"
                            id={`inline-radio-1`}
                            value="memberGet"
                            checked={giftInfo.gift_type === 'memberGet'}
                            onChange={handleChange}
                        />
                        <Form.Check
                            inline
                            label="준 선물"
                            name="gift_type"
                            type="radio"
                            id={`inline-radio-2`}
                            value="friendGet"
                            checked={giftInfo.gift_type === 'friendGet'}
                            onChange={handleChange}
                        />
                    </Col>
                </Row>
                <Row>
                    <Col md={12}>
                        <Form.Group className="mb-3">
                            <Form.Label>내용:</Form.Label>
                            <Form.Control
                                as="textarea"
                                rows={5}
                                name="content"
                                value={giftInfo.content}
                                onChange={handleChange}
                                placeholder="선물에 대한 추가 정보를 입력하세요"
                            />
                        </Form.Group>
                    </Col>
                </Row>
                <Button variant="success" type="submit">저장</Button>
            </Form>
        </Container>
    );
};

export default AddGift;

