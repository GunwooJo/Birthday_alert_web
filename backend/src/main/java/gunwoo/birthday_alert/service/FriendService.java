package gunwoo.birthday_alert.service;

import gunwoo.birthday_alert.entity.Friend;
import gunwoo.birthday_alert.entity.Member;
import gunwoo.birthday_alert.repository.FriendRepository;

import gunwoo.birthday_alert.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class FriendService {

    private final FriendRepository friendRepository;
    private final MemberRepository memberRepository;

    @Transactional(readOnly = false)
    public Long add(Friend friend) {
        return friendRepository.save(friend);
    }

    public List<Friend> showFriends(String email) {
        List<Member> memberList = memberRepository.findByEmail(email);
        Member member = memberList.get(0);
        return friendRepository.findByMemberId(member.getId());
    }
}
