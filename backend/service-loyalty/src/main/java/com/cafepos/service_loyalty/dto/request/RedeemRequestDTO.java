package com.cafepos.service_loyalty.dto.request;

import lombok.Data;

@Data
public class RedeemRequestDTO {
    private Long rewardId;
    private Long cusId;
}
