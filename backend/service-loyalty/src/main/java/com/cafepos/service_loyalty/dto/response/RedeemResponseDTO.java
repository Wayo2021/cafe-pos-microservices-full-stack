package com.cafepos.service_loyalty.dto.response;

import lombok.Data;

@Data
public class RedeemResponseDTO {
    private Long redeemId;

    private Long rewardId;
    private String rewardName; // 🌟 เติมชื่อของรางวัล

    private Long cusId;
    private String customerName; // 🌟 เติมชื่อลูกค้า (ดึงจาก User Service)

    private Integer usedPoint;

}
