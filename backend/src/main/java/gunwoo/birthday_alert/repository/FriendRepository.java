package gunwoo.birthday_alert.repository;

import gunwoo.birthday_alert.dto.DataToFindFriend;
import gunwoo.birthday_alert.entity.Friend;
import gunwoo.birthday_alert.entity.Member;
import jakarta.persistence.EntityManager;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class FriendRepository {

    private final EntityManager em;
    private final MemberRepository memberRepository;

    public Long save(DataToFindFriend data) {
        String email = data.getMyEmail();
        List<Member> memberList = memberRepository.findByEmail(email);
        Member findMember = memberList.get(0);

        Friend friend = data.getFriend();
        friend.setMember(findMember);

        em.persist(friend);
        return friend.getId();
    }

    public List<Friend> findByMemberId(Long memberId) {
        return em.createQuery("select f from Friend f where f.member = :memberId", Friend.class)
                .setParameter("memberId", memberId)
                .getResultList();
    }

    public Friend findById(Long id) {
        System.out.println("FriendRepository.findById");
        return em.find(Friend.class, id);
    }
}

