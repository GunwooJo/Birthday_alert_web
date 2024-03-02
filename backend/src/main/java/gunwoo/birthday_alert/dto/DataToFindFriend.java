package gunwoo.birthday_alert.dto;

import gunwoo.birthday_alert.entity.Friend;

import java.time.LocalDate;

public class DataToFindFriend {
    private Friend friend;
    private String myEmail;

    public Friend getFriend() {
        return friend;
    }

    public String getMyEmail() {
        return myEmail;
    }
}
