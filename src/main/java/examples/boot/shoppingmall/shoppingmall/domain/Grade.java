package examples.boot.shoppingmall.shoppingmall.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "grade")
@Getter
@Setter
public class Grade {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long gradId;
    @OneToMany(mappedBy = "grade",cascade = CascadeType.ALL)//Member클래스에 gradId 변수명 맞추기
    private List<Member> members;
    @Column(length = 10,nullable = false)
    private String name;
}
