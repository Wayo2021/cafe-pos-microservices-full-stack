package com.cafepos.service_loyalty.controller;

import com.cafepos.service_loyalty.dto.request.RedeemRequestDTO;
import com.cafepos.service_loyalty.entity.Redeem;
import com.cafepos.service_loyalty.service.RedeemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/redeems")
public class RedeemController {

    @Autowired
    private RedeemService redeemService;

    // ลูกค้ากดปุ่ม "แลกของรางวัล" ในแอป
    @PostMapping
    public ResponseEntity<Redeem> redeemItem(@RequestBody RedeemRequestDTO dto) {
        // โยนให้ Service ไปเช็คสต๊อก เช็คแต้ม (มี @Transactional คอยคุ้มกันอยู่!)
        Redeem history = redeemService.redeemItem(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(history);
    }

}
