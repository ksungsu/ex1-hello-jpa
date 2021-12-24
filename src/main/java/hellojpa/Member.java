package hellojpa;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

@Entity //JPA가 관리하는 객체
public class Member {

    @Id //DB PK와 연결
    private Long id;

    @Column(name = "name")
    private String username;

    private Integer age;

    //사용자 또는 관리자
    @Enumerated(EnumType.STRING)
    private RoleType roleType;

    //생성 일자
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdDate;

    //수정 일자
    @Temporal(TemporalType.TIMESTAMP)
    private Date lastModifiedDate;

    private LocalDate testLocalDate;
    private LocalDateTime testLocalDateTime;

    @Lob
    private String description;


    public Member() {
    }


}
