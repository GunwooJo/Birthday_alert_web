package gunwoo.birthday_alert.controller;

import gunwoo.birthday_alert.dto.DataToFindFriend;
import gunwoo.birthday_alert.dto.FriendDTO;
import gunwoo.birthday_alert.entity.Friend;
import gunwoo.birthday_alert.service.FriendService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/friend")
@RequiredArgsConstructor
public class FriendController {

    private final FriendService friendService;

    @PostMapping("/addFriend")
    public ResponseEntity<?> addFriend(@RequestBody DataToFindFriend data) {
        friendService.add(data);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/getInfo")
    public ResponseEntity<FriendDTO> showFriendDetail(@RequestParam Long friendId) {
        Friend friend = friendService.showFriendDetail(friendId);
        FriendDTO friendDTO = friendService.convertToDTO(friend);
        return ResponseEntity.ok(friendDTO);
    }
}
