package gunwoo.birthday_alert.service;

import gunwoo.birthday_alert.dto.DataToFindFriend;
import gunwoo.birthday_alert.dto.FriendDTO;
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
    public Long add(DataToFindFriend data) {
        return friendRepository.save(data);
    }

    public List<Friend> showFriends(String email) {
        List<Member> memberList = memberRepository.findByEmail(email);
        Member member = memberList.get(0);
        return member.getFriends();
    }

    //controller에서 응답으로 entity를 넘기지 말고 이 DTO를 넘겨서 view단에서 필요한 정보만 넘기도록 하자.
    public FriendDTO convertToDTO(Friend friend) {
        return new FriendDTO(friend.getName(), friend.getBirthday());
    }
}
