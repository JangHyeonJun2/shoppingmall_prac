package examples.boot.shoppingmall.shoppingmall.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "member")
@Getter
@Setter
public class Member {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long memberId;//카멜케이스
    @Column(length = 255,nullable = false)
    private String email;
    @Column(length = 30,nullable = false)
    private String name;
    private String nickname;
    @Column(length = 15,nullable = false)
    private String password;
    @Column(length = 15,nullable = false)
    private String phoneNumber;//카멜케이스
    @Column(length = 255,nullable = false)
    private String address;
    @Column(length = 255,nullable = false)
    private String postad;
    private int length;
    private int weight;
    @Column(nullable = false)
    private char gender;
    @Column(nullable = false)
    private int birthdaty;
    private int point;
    @ManyToOne
    @JoinColumn(name = "grade_id")
    private Grade grade;
    @ManyToMany(fetch = FetchType.LAZY,mappedBy = "members")
    private List<Coupon> coupons;
    @OneToMany(mappedBy = "member",cascade = CascadeType.ALL)
    private List<Orders> orders;
}
