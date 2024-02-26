package gunwoo.birthday_alert.dto;

import gunwoo.birthday_alert.entity.Friend;

import java.time.LocalDate;

public class FriendDTO {
    private String name;

    private LocalDate birthday;

    public FriendDTO(String name, LocalDate birthday) {
        this.name = name;
        this.birthday = birthday;
    }

    //controller에서 응답으로 entity를 넘기지 말고 이 DTO를 넘겨서 view단에서 필요한 정보만 넘기도록 하자.
    public static FriendDTO from(Friend friend) {
        return new FriendDTO(friend.getName(), friend.getBirthday());
    }
}
