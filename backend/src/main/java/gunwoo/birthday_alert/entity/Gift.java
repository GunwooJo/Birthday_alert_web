package gunwoo.birthday_alert.entity;

import jakarta.persistence.*;
import lombok.Getter;

import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Getter
public class Gift {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "friend_id")
    private Friend friend;

    private LocalDate date;

    @Enumerated(EnumType.STRING)
    private GiftType gift_type;

    private String name;

    private BigDecimal price;
}
