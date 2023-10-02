package fa.training.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Member implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String firstName;
    private String lastName;
    private String userName;
    @NotBlank(message = "{error.notblank.password}")
    private String passWord;
    private String phone;
    @NotBlank(message = "{error.notblank.email}")
    private String email;
    private String description;
    private LocalDate createdDate;
    private LocalDate updateTime;

    @OneToMany(mappedBy = "member")
    private List<MemberRoles> memberRoles;

    @OneToMany(mappedBy = "member", cascade = CascadeType.ALL)
    private List<Content> contents;
}
