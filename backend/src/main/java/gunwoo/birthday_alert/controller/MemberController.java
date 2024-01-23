package gunwoo.birthday_alert.controller;

import gunwoo.birthday_alert.entity.Member;
import gunwoo.birthday_alert.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@RequestMapping("/member")
public class MemberController {

    private final MemberService memberService;

    @PostMapping("/addMember")
    public ResponseEntity<?> addMember(@RequestBody Member member) {
        memberService.join(member);
        return ResponseEntity.ok().build();
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

}
