package com.cafepos.service_report.service;

import com.cafepos.service_report.entity.ResultDay;
import com.cafepos.service_report.repository.ResultDayRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public class ReportService {

    @Autowired
    private ResultDayRepository resultDayRepository;

    // Method นี้อาจจะถูกตั้งเวลาให้ทำงานอัตโนมัติทุกๆ เที่ยงคืน (Cron Job)
    public ResultDay generateDailyReport(LocalDate targetDate) {

        // [จำลอง] ยิง API ไปที่ Order Service ขอข้อมูลยอดขายของ targetDate
        // เช่น GET /api/orders/summary?date=2026-03-12
        double totalIncomeFromOrderService = 4500.0;
        int totalOrdersFromOrderService = 35;
        int totalDrinksSoldFromOrderService = 52;

        // เอาข้อมูลที่ได้มาประกอบร่างเซฟลง Database
        ResultDay report = new ResultDay();
        report.setDate(targetDate);
        report.setTotalIncome(totalIncomeFromOrderService);
        report.setTotalOrders(totalOrdersFromOrderService);
        report.setTotalDrinksSold(totalDrinksSoldFromOrderService);

        return resultDayRepository.save(report);
    }

}
