package fa.training.consts;

import lombok.Getter;

@Getter
public enum RoleEnum {
    ADMIN (1, "ADMIN"),
    STAFF(2, "STAFF"),
    MEMBER(3, "MEMBER"),
    ;
    private int id;
    private String name;

    private RoleEnum(int id, String name) {
        this.id = id;
        this.name = name;
    }

}
