import React, { useState } from 'react';
import axios from "axios";

interface FriendBirthday {
    name: string;
    birthday: string;
}

const AddFriend = () => {
    const [friend, setFriend] = useState<FriendBirthday>({ name: '', birthday: '' });

    const handleInputChange = (event: React.ChangeEvent<HTMLInputElement>) => {
        setFriend({ ...friend, [event.target.name]: event.target.value });
    };

    const handleSubmit = async (event: React.FormEvent) => {
        event.preventDefault();
        console.log('Adding Friend\'s Birthday:', friend);

        try {
            const response = await axios.post('/friend/addFriend', friend);
            console.log('Friend added successfully:', response);
            alert('친구의 생일을 기억할게요.');

        } catch (error) {
            alert('생일 저장에 실패했어요.');
            console.error('Error adding friend:', error.response ? error.response.data : error.message);
        }
    };

    return (
        <form onSubmit={handleSubmit}>
            <div>
                <label>
                    Name:
                    <input type="text" name="name" value={friend.name} onChange={handleInputChange} />
                </label>
            </div>
            <div>
                <label>
                    Birthday:
                    <input type="date" name="birthday" value={friend.birthday} onChange={handleInputChange} />
                </label>
            </div>
            <button type="submit">Add Birthday</button>
        </form>
    );
};

export default AddFriend;
