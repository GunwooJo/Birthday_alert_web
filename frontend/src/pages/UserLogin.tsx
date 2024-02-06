import React, { useState } from 'react';
import axios from "axios";

const UserLogin: React.FC = () => {
    const [email, setEmail] = useState('');
    const [password, setPassword] = useState('');

    const handleSubmit = async (event: React.FormEvent<HTMLFormElement>) => {
        event.preventDefault();

        try {
            const response = await axios.post('/user/login', {
                email: email,
                password: password
            });

            if (response.status === 200) {
                alert('로그인 성공');
            }
        } catch (error) {
            console.error(error);
            alert('로그인에 실패했어요.');
        }

        console.log('Email:', email);
        console.log('Password:', password);
    };

    return (
        <form onSubmit={handleSubmit}>
            <div>
                <label htmlFor="email">이메일</label>
                <input
                    type="email"
                    id="email"
                    value={email}
                    onChange={(e) => setEmail(e.target.value)}
                />
            </div>
            <div>
                <label htmlFor="password">비밀번호</label>
                <input
                    type="password"
                    id="password"
                    value={password}
                    onChange={(e) => setPassword(e.target.value)}
                />
            </div>
            <button type="submit">Login</button>
        </form>
    );
};

export default UserLogin;
