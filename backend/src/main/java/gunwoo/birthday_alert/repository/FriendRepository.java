package gunwoo.birthday_alert.repository;

import gunwoo.birthday_alert.entity.Friend;
import jakarta.persistence.EntityManager;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class FriendRepository {

    private final EntityManager em;

    public Long save(Friend friend) {
        em.persist((friend));
        return friend.getId();
    }

    public List<Friend> findByMemberId(Long memberId) {
        return em.createQuery("select f from Friend f where f.member = :memberId", Friend.class)
                .setParameter("memberId", memberId)
                .getResultList();
    }

}

