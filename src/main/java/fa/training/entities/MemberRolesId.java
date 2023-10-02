package fa.training.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Embeddable
@Getter
@Setter
public class MemberRolesId implements Serializable {

    @Column(name = "roles_id")
    private Integer roleId;

    @Column(name = "member_id")
    private Integer memberId;

}
