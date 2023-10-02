package fa.training.service;

import fa.training.entities.Member;
import fa.training.repositories.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MemberServiceImpl implements MemberService {
    @Autowired
    private MemberRepository memberRepository;

    @Override
    public Member checkLogin(String email, String password) {
        return memberRepository.checkLogin(email,password);
    }
}
