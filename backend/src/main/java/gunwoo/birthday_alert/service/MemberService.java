package gunwoo.birthday_alert.service;

import gunwoo.birthday_alert.entity.Member;
import gunwoo.birthday_alert.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class MemberService {

    private final MemberRepository memberRepository;
    //private BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    public Long join(Member member) {
        //member.setPassword(passwordEncoder.encode(member.getPassword()));
        return memberRepository.save(member);
    }

    public boolean login(String email, String password) {
        List<Member> memberList = memberRepository.findByEmail(email);
        if (memberList.get(0) != null && memberList.get(0).getPassword().equals(password)) {
            return true;
        }
        return false;
    }

    public boolean validateDuplicateMember(String email) {
        List<Member> findMembers = memberRepository.findByEmail(email);

        if(!findMembers.isEmpty()) {
            return true;
        } else {
            return false;
        }
    }

}
