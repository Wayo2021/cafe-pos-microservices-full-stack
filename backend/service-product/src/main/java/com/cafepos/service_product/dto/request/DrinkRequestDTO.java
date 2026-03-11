package com.cafepos.service_product.dto.request;

import lombok.Data;

@Data
public class DrinkRequestDTO {

    private String drinkName;
    private Double drinkPrice;
    private String drinkType;

}
