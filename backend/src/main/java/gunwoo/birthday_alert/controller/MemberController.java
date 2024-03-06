package gunwoo.birthday_alert.controller;

import gunwoo.birthday_alert.dto.FriendDTO;
import gunwoo.birthday_alert.entity.Friend;
import gunwoo.birthday_alert.entity.Member;
import gunwoo.birthday_alert.service.FriendService;
import gunwoo.birthday_alert.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/member")
public class MemberController {

    private final MemberService memberService;
    private final FriendService friendService;

    @PostMapping("/addMember")
    public ResponseEntity<?> addMember(@RequestBody Member member) {
        memberService.join(member);
        return ResponseEntity.ok().build();
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody Member member) {
        boolean isLoginSuccess = memberService.login(member.getEmail(), member.getPassword());

        if(isLoginSuccess) {
            return ResponseEntity.ok().body(member.getEmail());
        } else {
            return ResponseEntity.badRequest().body("로그인에 실패했어요.");
        }

    }

    @GetMapping("/checkEmailDuplication")
    public ResponseEntity<?> checkEmailDuplication(@RequestParam String email) {
        boolean isEmailTaken = memberService.validateDuplicateMember(email);

        if (isEmailTaken) {
            return ResponseEntity.status(409).body("이미 사용 중인 이메일입니다.");
        } else {
            return ResponseEntity.ok("사용 가능한 이메일입니다.");
        }
    }

    @GetMapping("/showFriends")
    public ResponseEntity<List<FriendDTO>> showFriends(@RequestParam String email) {
        List<Friend> friends = friendService.showFriends(email);

        List<FriendDTO> friendDTOS = new ArrayList<>();

        for(Friend friend: friends) {
            FriendDTO friendDTO = friendService.convertToDTO(friend);
            friendDTOS.add(friendDTO);
        }
        return ResponseEntity.ok(friendDTOS);
    }

}
