package examples.boot.shoppingmall.shoppingmall.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "orders")
@Getter
@Setter
/*
회원 1:N 주문(fk(회원id))
 */
public class Orders {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private String orderNum;//주문번호
    private Date orderDate;//주문일시
    @Column(nullable = false)
    private int orderPrice;//주문금액
    private int discountPrice;//할인금액
    private int saveMoney;//적립금
    private int productAmount;
    @ManyToOne(fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    @JoinColumn(name = "member_id")
    private Member member;
}
