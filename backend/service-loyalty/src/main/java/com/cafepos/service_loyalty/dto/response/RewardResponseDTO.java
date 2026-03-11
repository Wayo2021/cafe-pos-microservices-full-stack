package com.cafepos.service_loyalty.dto.response;

import lombok.Data;

@Data
public class RewardResponseDTO {
    private Long rewardId;
    private String rewardName;
    private Integer rewardPoint;
    private Integer remain;
}
