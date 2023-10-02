package fa.training.repositories;

import fa.training.entities.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface MemberRepository extends JpaRepository<Member,Integer> {

    @Query(value = "SELECT m FROM Member m WHERE m.email = ?1 AND m.passWord = ?2")     //JPQL  java persitence query language
    public Member checkLogin(String email, String password);

    Member findByEmail(String email);
}
