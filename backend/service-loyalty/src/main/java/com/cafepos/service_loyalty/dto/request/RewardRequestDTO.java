package com.cafepos.service_loyalty.dto.request;

import lombok.Data;

@Data
public class RewardRequestDTO {
    private String rewardName;
    private Integer rewardPoint;
    private Integer remain;
}
