package com.cafepos.service_user.controller;

import com.cafepos.service_user.dto.request.CustomerRequestDTO;
import com.cafepos.service_user.entity.Customer;
import com.cafepos.service_user.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/customers")
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    //  สร้างลูกค้าใหม่ (รับข้อมูลจาก Body)
    @PostMapping
    public ResponseEntity<Customer> createCustomer(@RequestBody CustomerRequestDTO dto) {
        Customer newCustomer = customerService.createCustomer(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(newCustomer);
    }

    //  อัปเดตแต้ม (รับ ID จาก URL, รับจำนวนแต้มจาก Query Param เช่น ?points=50 หรือ ?points=-10)
    //  API นี้เตรียมไว้ให้ Order Service หรือ Loyalty Service ยิงมาหาครับ!
    @PutMapping("/{cusId}/points")
    public ResponseEntity<String> updatePoints(
            @PathVariable("cusId") Long cusId,
            @RequestParam("points") Integer points) {

        customerService.updatePoints(cusId, points);
        return ResponseEntity.ok("อัปเดตแต้มเรียบร้อยแล้ว!");
    }
}
