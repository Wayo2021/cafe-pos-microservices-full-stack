package com.cafepos.service_order.dto.response;

import lombok.Data;

@Data
public class OrderDetailResponseDTO {
    private Long orderDetailId;

    // 🌟 นำ ID ไปดึงชื่อจาก Product Service มาประกอบร่างแล้ว!
    private Long drinkId;
    private String drinkName;

    private Integer amount;
    private Double subTotal;
}
