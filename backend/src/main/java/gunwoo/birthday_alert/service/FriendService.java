package gunwoo.birthday_alert.service;

import gunwoo.birthday_alert.entity.Friend;
import gunwoo.birthday_alert.repository.FriendRepository;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class FriendService {

    private final FriendRepository friendRepository;

    @Transactional(readOnly = false)
    public Long add(Friend friend) {
        return friendRepository.save(friend);
    }
}
