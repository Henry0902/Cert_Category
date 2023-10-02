package fa.training.service;

import fa.training.entities.Member;

public interface MemberService {
    Member checkLogin(String email, String passWord);
}
