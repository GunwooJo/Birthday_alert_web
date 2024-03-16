package gunwoo.birthday_alert.dto;

import gunwoo.birthday_alert.entity.GiftType;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.Getter;

import java.time.LocalDate;

@Getter
public class GiftDTO {

    private LocalDate date;

    @Enumerated(EnumType.STRING)
    private GiftType gift_type;

    private String name;

    private String content;

    public GiftDTO(LocalDate date, GiftType gift_type, String name, String content) {
        this.date = date;
        this.gift_type = gift_type;
        this.name = name;
        this.content = content;
    }
}
