package fa.training.repositories;

import fa.training.entities.Member;
import fa.training.entities.MemberRoles;
import fa.training.entities.MemberRolesId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MemberRolesRepository extends JpaRepository<MemberRoles, MemberRolesId> {
//    @Query(value = "SELECT m FROM Member m ") //JPQL  java persitence query language
    List<MemberRoles> findAllByMember(Member member);


}
