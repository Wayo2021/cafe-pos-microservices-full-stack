package com.cafepos.service_order.dto.request;

import lombok.Data;

@Data
public class OrderDetailRequestDTO {
    private Long drinkId; // รหัสน้ำ
    private Integer amount; // จำนวนแก้ว
}
