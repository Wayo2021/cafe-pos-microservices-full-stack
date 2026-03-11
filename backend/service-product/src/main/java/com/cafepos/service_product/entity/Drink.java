package com.cafepos.service_product.entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "drinks")

public class Drink {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "drink_id")
    private Long drinkId; // PK

    @Column(name = "drink_name", nullable = false)
    private String drinkName;

    @Column(name = "drink_price", nullable = false)
    private Double drinkPrice;

    @Column(name = "drink_type")
    private String drinkType; // เช่น Coffee, Tea, Soda

}
