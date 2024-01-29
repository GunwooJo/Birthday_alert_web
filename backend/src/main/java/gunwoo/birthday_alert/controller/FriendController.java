package gunwoo.birthday_alert.controller;

import gunwoo.birthday_alert.entity.Friend;
import gunwoo.birthday_alert.service.FriendService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/friend")
@RequiredArgsConstructor
public class FriendController {

    private final FriendService friendService;

    @PostMapping("addFriend")
    public ResponseEntity<?> addFriend(@RequestBody Friend friend) {
        friendService.add(friend);
        return ResponseEntity.ok().build();
    }
}
