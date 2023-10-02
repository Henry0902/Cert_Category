package fa.training.auth;
import fa.training.entities.Member;
import fa.training.entities.MemberRoles;
import fa.training.repositories.MemberRepository;
import fa.training.repositories.MemberRolesRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.List;

@Service
@Transactional(rollbackOn = SQLException.class)
public class CustomMemberDetailService implements UserDetailsService {

    @Autowired
    private MemberRepository memberRepository;

    @Autowired
    private MemberRolesRepository memberRolesRepository;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        Member emailDB = memberRepository.findByEmail(email);
        List<MemberRoles> rolesList = memberRolesRepository.findAllByMember(emailDB);
        emailDB.setMemberRoles(rolesList);
        return new CustomMemberDetails(emailDB);
    }
}
