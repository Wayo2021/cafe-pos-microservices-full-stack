package com.cafepos.service_report.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;

@Data
@Entity
@Table(name = "result_days")
public class ResultDay {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "result_id")
    private Long resultId;

    private LocalDate date;

    @Column(name = "total_income")
    private Double totalIncome;

    @Column(name = "total_orders")
    private Integer totalOrders;

    @Column(name = "total_drinks_sold")
    private Integer totalDrinksSold;

}
