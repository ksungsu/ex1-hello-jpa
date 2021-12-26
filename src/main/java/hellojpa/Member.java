package hellojpa;

import javax.persistence.*;

@Entity //JPA가 관리하는 객체
@SequenceGenerator(name = "MEMBER_SEQ_GENERATOR",
                    sequenceName = "MEMBER_SEQ")
public class Member {

    @Id //DB PK와 연결
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "MEMBER_SEQ_GENERATOR")
    @Column(name="MEMBER_ID")
    private Long id;

    @Column(name = "USERNAME")
    private String username;

    //    @Column(name="TEAM_ID") //테이블에 맞춰 객체 설계(연관관계 x)
    //    private Long teamId;

    @ManyToOne
    @JoinColumn(name="TEAM_ID")
    private Team team;

    public Member() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Team getTeam() {
        return team;
    }

    public void setTeam(Team team) {
        this.team = team;
    }
}
