package gunwoo.birthday_alert.service;

import gunwoo.birthday_alert.dto.FriendDTO;
import gunwoo.birthday_alert.dto.GiftDTO;
import gunwoo.birthday_alert.entity.Friend;
import gunwoo.birthday_alert.entity.Gift;
import gunwoo.birthday_alert.repository.GiftRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class GiftService {

    private final GiftRepository giftRepository;

    public List<Gift> getGiftList(Long id) {
        return giftRepository.findById(id);
    }

    public GiftDTO convertToDTO(Gift gift) {
        return new GiftDTO(gift.getDate(), gift.getGift_type(), gift.getName(), gift.getContent());
    }
}
