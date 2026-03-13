package com.cafepos.service_report.controller;

import com.cafepos.service_report.entity.ResultDay;
import com.cafepos.service_report.service.ReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;

@RestController
@RequestMapping("/api/reports")
public class ReportController {

    @Autowired
    private ReportService reportService;

    // สั่งให้ระบบสร้าง Report ของวันที่ต้องการ
    // ตัวอย่างการเรียก: POST /api/reports/generate?targetDate=2026-03-12
    @PostMapping("/generate")
    public ResponseEntity<ResultDay> generateDailyReport(
            @RequestParam("targetDate")
            @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate targetDate) {

        // โยนวันที่ไปให้ Service จัดการดึงข้อมูลจาก Order Service มาสรุป
        ResultDay report = reportService.generateDailyReport(targetDate);
        return ResponseEntity.status(HttpStatus.CREATED).body(report);
    }

}
