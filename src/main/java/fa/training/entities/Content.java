package fa.training.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
@Entity
public class Content implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String title;
    private String brief;
    private String content;
    private LocalDate createDate;
    private LocalDate updateTime;
    private String authorId;

    @ManyToOne
    @JoinColumn(name = "member_id")
    private Member member;
}
