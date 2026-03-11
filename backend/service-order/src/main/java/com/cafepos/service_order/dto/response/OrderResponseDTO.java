package com.cafepos.service_order.dto.response;

import lombok.Data;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

@Data
public class OrderResponseDTO {
    private Long orderId;
    private LocalDate date;
    private LocalTime time;
    private Double totalPrice;
    private Integer earnedPoint;

    // 🌟 นำ ID ไปดึงชื่อจาก User Service มาประกอบร่างแล้ว!
    private Long empId;
    private String employeeName;

    private Long cusId;
    private String customerName;

    private List<OrderDetailResponseDTO> orderDetails;
}
