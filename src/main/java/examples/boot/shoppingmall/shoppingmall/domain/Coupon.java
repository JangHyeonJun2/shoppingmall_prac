package examples.boot.shoppingmall.shoppingmall.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "coupon")
@Getter
@Setter
public class Coupon {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long counponId;
    @Column(length = 255,nullable = false)
    private String couponeName;
    @Column(nullable = false)
    private int discountPrice;
    @Column(nullable = false)
    private double discountRate;
    private Date expirreDate;
    @ManyToMany(fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    @JoinTable(name = "coupon_has_member",
            joinColumns = @JoinColumn(name = "coupon_id"),
            inverseJoinColumns = @JoinColumn(name = "member_id"))
    private List<Member> members;
}
