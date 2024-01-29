package gunwoo.birthday_alert.repository;

import gunwoo.birthday_alert.entity.Friend;
import jakarta.persistence.EntityManager;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class FriendRepository {

    private final EntityManager em;

    public Long save(Friend friend) {
        em.persist((friend));
        return friend.getId();
    }

}

