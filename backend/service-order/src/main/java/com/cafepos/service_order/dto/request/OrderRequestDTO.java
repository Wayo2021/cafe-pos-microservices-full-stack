package com.cafepos.service_order.dto.request;

import lombok.Data;

import java.util.List;

@Data
public class OrderRequestDTO {
    private Long empId;   // ใครเป็นคนชง
    private Long cusId;  // ใครเป็นคนซื้อ (ถ้าไม่เป็นสมาชิกอาจส่งเป็น null)

    // รายการน้ำที่สั่ง (รับมาแค่รหัสน้ำ กับ จำนวนแก้ว)
    private List<OrderDetailRequestDTO> orderDetails;
}
