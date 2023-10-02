package fa.training.auth;
import fa.training.entities.Member;
import fa.training.entities.MemberRoles;
import fa.training.entities.Roles;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class CustomMemberDetails implements UserDetails {

    private Member member;

    public CustomMemberDetails() {
    }
    public CustomMemberDetails(Member members) {
        this.member = members;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {

        List<GrantedAuthority> authorities = new ArrayList<>();
        List<MemberRoles> memberRoles = member.getMemberRoles();
        memberRoles.forEach(ur -> {
            Roles role = ur.getRoles();
            GrantedAuthority authority = new SimpleGrantedAuthority(role.getName());

            authorities.add(authority);
        });
        return authorities;
    }

    @Override
    public String getPassword() {
        return member.getPassWord();
    }

//    @Override
//    public String getEmail() {
//        return member.getEmail();
//    }

    @Override
    public String getUsername() {
        return member.getEmail();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
