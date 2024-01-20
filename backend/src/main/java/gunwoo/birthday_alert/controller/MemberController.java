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

}
