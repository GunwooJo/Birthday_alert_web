package gunwoo.birthday_alert.dto;

import gunwoo.birthday_alert.entity.Friend;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
public class FriendDTO {

    private Long id;

    private String name;

    private LocalDate birthday;

    public FriendDTO(Long id, String name, LocalDate birthday) {
        this.id = id;
        this.name = name;
        this.birthday = birthday;
    }

}
