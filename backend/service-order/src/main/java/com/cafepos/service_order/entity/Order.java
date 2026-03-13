package com.cafepos.service_order.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

@Data
@Entity
@Table(name = "orders")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "order_id")
    private Long orderId; // PK

    private LocalDate date;
    private LocalTime time;
    private Double totalPrice;
    private Integer earnedPoint;

    // Logical FK (อ้างอิงข้าม Service)
    // สังเกตว่าเราใช้แค่ตัวแปร Long ธรรมดาเลย! ไม่ได้ใช้ @ManyToOne เชื่อมกับคลาส User
    @Column(name = "emp_id")
    private Long empId;

    @Column(name = "cus_id")
    private Long cusId;

    // Physical FK (เชื่อมกับรายการน้ำใน Service เดียวกัน)
    // 1 บิลหลัก มีได้หลายรายการย่อย (One-to-Many)
    @OneToMany(mappedBy = "order", cascade = CascadeType.ALL)
    private List<OrderDetail> orderDetails;

}
