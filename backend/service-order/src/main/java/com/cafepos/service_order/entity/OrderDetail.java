package com.cafepos.service_order.entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "order_details")
public class OrderDetail {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "order_detail_id")
    private Long orderDetailId; // 🔑 PK

    // Physical FK (ลูกชี้กลับไปหาแม่)
    @ManyToOne
    @JoinColumn(name = "order_id", nullable = false) // สร้างคอลัมน์ order_id เป็น FK ใน DB จริงๆ
    private Order order;

    // Logical FK (อ้างอิงไปหา Product Service)
    @Column(name = "drink_id", nullable = false)
    private Long drinkId; // เก็บแค่รหัสน้ำ ไม่ได้สร้างเส้นเชื่อม Database

    private Integer amount;
    private Double subTotal;
}
