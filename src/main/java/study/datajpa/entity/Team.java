package study.datajpa.entity;

import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@ToString(of = {"id", "name"})
public class Team {

    @Id
    @SequenceGenerator(name = "TEAM_SEQ_SPRING_JPA",
            sequenceName = "TEAM_SEQ_SPRING_JPA")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "TEAM_SEQ_SPRING_JPA")
    @Column(name = "team_id")
    private Long id;
    private String name;
    @OneToMany(mappedBy = "team")
    private List<Member> members = new ArrayList<>();

    public Team(String name) {
        this.name = name;
    }
}
