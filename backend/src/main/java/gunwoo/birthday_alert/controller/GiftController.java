package gunwoo.birthday_alert.controller;

import gunwoo.birthday_alert.dto.GiftDTO;
import gunwoo.birthday_alert.entity.Friend;
import gunwoo.birthday_alert.entity.Gift;
import gunwoo.birthday_alert.repository.FriendRepository;
import gunwoo.birthday_alert.service.GiftService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequiredArgsConstructor
public class GiftController {

    private final GiftService giftService;
    private final FriendRepository friendRepository;

    @GetMapping("/gift/list")
    public ResponseEntity<List<GiftDTO>> giftList(@RequestParam Long friendId) {
        List<Gift> gifts = giftService.getGiftList(friendId);
        List<GiftDTO> giftDTOS = new ArrayList<>();

        for (Gift gift : gifts) {
            GiftDTO giftDTO = giftService.convertToDTO(gift);
            giftDTOS.add(giftDTO);
        }

        return ResponseEntity.ok(giftDTOS);
    }

    @PostMapping("/gift/add/{friendId}")
    public ResponseEntity<?> addGift(@PathVariable Long friendId, @RequestBody() Gift giftInfo) {
        Friend friend = friendRepository.findById(friendId);
        giftInfo.setFriend(friend);
        giftService.addGift(giftInfo);
        return ResponseEntity.ok().build();
    }
}
