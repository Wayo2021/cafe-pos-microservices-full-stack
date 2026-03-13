package com.cafepos.service_loyalty.entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "redeems")
public class Redeem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "redeem_id")
    private Long redeemId;

    // Physical FK (ลูกชี้กลับไปหาของรางวัล)
    @ManyToOne
    @JoinColumn(name = "reward_id", nullable = false)
    private Reward reward;

    // Logical FK (ชี้ไปหาลูกค้าใน User Service)
    @Column(name = "cus_id", nullable = false)
    private Long cusId;

    @Column(name = "used_point", nullable = false)
    private Integer usedPoint;

}
