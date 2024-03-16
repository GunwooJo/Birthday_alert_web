package gunwoo.birthday_alert.repository;

import gunwoo.birthday_alert.entity.Gift;
import gunwoo.birthday_alert.entity.Member;
import jakarta.persistence.EntityManager;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class GiftRepository {

    private final EntityManager em;

    public List<Gift> findById(Long friendId) {
        return em.createQuery("select g from Gift g where g.friend.id = :friendId", Gift.class)
                .setParameter("friendId", friendId)
                .getResultList();
    }

    public Long save(Gift gift) {
        System.out.println("GiftRepository.save");
        em.persist(gift);
        return gift.getId();
    }
}
