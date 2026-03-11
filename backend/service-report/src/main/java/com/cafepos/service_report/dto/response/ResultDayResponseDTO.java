package com.cafepos.service_report.dto.response;

import lombok.Data;

import java.time.LocalDate;

@Data
public class ResultDayResponseDTO {
    private Long resultId;
    private LocalDate date;
    private Double totalIncome;
    private Integer totalOrders;
    private Integer totalDrinksSold;
}
