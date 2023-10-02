package fa.training.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Entity
@Getter
@Setter
public class MemberRoles implements Serializable {

    @EmbeddedId
    private MemberRolesId id;

    @ManyToOne
    @MapsId("member_id")
    @JoinColumn(name = "member_id")
    private Member member;

    @ManyToOne
    @MapsId("roles_id")
    @JoinColumn(name = "roles_id")
    private Roles roles;

}
