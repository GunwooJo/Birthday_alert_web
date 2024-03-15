package gunwoo.birthday_alert.controller;

import gunwoo.birthday_alert.dto.GiftDTO;
import gunwoo.birthday_alert.entity.Gift;
import gunwoo.birthday_alert.service.GiftService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequiredArgsConstructor
public class GiftController {

    private final GiftService giftService;

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
}
