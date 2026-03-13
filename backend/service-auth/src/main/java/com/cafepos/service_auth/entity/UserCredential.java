package com.cafepos.service_auth.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "user_credentials")
public class UserCredential {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true, nullable = false)
    private String username;

    @Column(nullable = false)
    private String password; // จะเก็บแบบเข้ารหัส (BCrypt) เสมอ!

    private String role; // เช่น "ROLE_CASHIER", "ROLE_MANAGER", "ROLE_CUSTOMER"

    private Long refId; // Logical FK: ชี้กลับไปที่ empId หรือ cusId ใน service-user
}
