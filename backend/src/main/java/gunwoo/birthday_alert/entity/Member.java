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

    @JsonIgnore //순환참조를 막기 위해 사용한다는데 정확히 이걸 쓰면 왜 오류가 사라지는지 모르겠다. -> 양방향 관계가 설정된 entity를 response할 경우 entity를 json을 바꾸는 과정에서 무한으로 순환참조가 일어나게 된다. 따라서, entity를 직접 response하지 말고 DTO를 만들어 필요한 데이터만 응답하도록 하자.
    // 이 어노테이션을 붙이면 json 데이터에 해당 프로퍼티는 null로 들어가게 된다.
    @OneToMany(mappedBy = "member")
    private List<Friend> friends;

    @Setter
    private String password;

    private String nickname;

    private String name;
}
