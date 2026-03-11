package com.cafepos.service_product.dto.response;

import lombok.Data;

@Data
public class DrinkResponseDTO {
    private Long drinkId;
    private String drinkName;
    private Double drinkPrice;
    private String drinkType;
}
