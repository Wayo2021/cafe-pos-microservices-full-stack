package com.cafepos.service_loyalty.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Data
@Entity
@Table(name = "rewards")
public class Reward {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "reward_id")
    private Long rewardId;

    @Column(name = "reward_name", nullable = false)
    private String rewardName;

    @Column(name = "reward_point", nullable = false)
    private Integer rewardPoint;

    private Integer remain;

    // 🔗 Physical FK (เชื่อมกับประวัติการแลก)
    @OneToMany(mappedBy = "reward", cascade = CascadeType.ALL)
    private List<Redeem> redeemRewards;

}
