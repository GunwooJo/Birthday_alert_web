import React, { useState } from 'react';

interface FriendBirthday {
    name: string;
    birthday: string;
}

const AddBirthday = () => {
    const [friend, setFriend] = useState<FriendBirthday>({ name: '', birthday: '' });

    const handleInputChange = (event: React.ChangeEvent<HTMLInputElement>) => {
        setFriend({ ...friend, [event.target.name]: event.target.value });
    };

    const handleSubmit = (event: React.FormEvent) => {
        event.preventDefault();
        console.log('Adding Friend\'s Birthday:', friend);
        // Here you can add code to save the friend's birthday
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

export default AddBirthday;
