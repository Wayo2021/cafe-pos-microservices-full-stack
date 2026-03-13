package com.cafepos.service_order.controller;

import com.cafepos.service_order.dto.request.OrderRequestDTO;
import com.cafepos.service_order.entity.Order;
import com.cafepos.service_order.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/orders")
public class OrderController {

    @Autowired
    private OrderService orderService;

    // แคชเชียร์กดปุ่ม "ชำระเงิน" หน้าบ้านจะส่ง OrderRequestDTO ก้อนใหญ่มาที่นี่
    @PostMapping
    public ResponseEntity<Order> placeOrder(@RequestBody OrderRequestDTO dto) {
        // โยนให้ Service ไปคิดเงิน, หักสต๊อก, แจกแต้ม (ที่มีการยิง API ข้าม Service)
        Order savedOrder = orderService.placeOrder(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedOrder);
    }
}
