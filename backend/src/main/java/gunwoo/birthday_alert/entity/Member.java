package gunwoo.birthday_alert.entity;


import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Getter
public class Member {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "member_id")
    private Long id;

    private String email;

    @JsonIgnore //순환참조를 막기 위해 사용한다는데 정확히 이걸 쓰면 왜 오류가 사라지는지 모르겠다.
    @OneToMany(mappedBy = "member")
    private List<Friend> friends;

    @Setter
    private String password;

    private String nickname;

    private String name;
}
