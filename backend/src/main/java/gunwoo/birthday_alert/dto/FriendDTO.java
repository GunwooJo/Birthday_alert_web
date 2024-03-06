package gunwoo.birthday_alert.dto;

import gunwoo.birthday_alert.entity.Friend;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
public class FriendDTO {
    private String name;

    private LocalDate birthday;

    public FriendDTO(String name, LocalDate birthday) {
        this.name = name;
        this.birthday = birthday;
    }

}
