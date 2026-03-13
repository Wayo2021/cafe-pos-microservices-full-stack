package com.cafepos.service_product.controller;

import com.cafepos.service_product.dto.request.DrinkRequestDTO;
import com.cafepos.service_product.entity.Drink;
import com.cafepos.service_product.service.DrinkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/drinks")
public class DrinkController {

    @Autowired
    private DrinkService drinkService;

    //  ผู้จัดการร้านเพิ่มเมนูใหม่
    @PostMapping
    public ResponseEntity<Drink> createDrink(@RequestBody DrinkRequestDTO dto) {
        Drink newDrink = drinkService.createDrink(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(newDrink);
    }

    //  ดึงข้อมูลเมนู 1 แก้ว (รับ ID จาก URL)
    //  API นี้เตรียมไว้ให้ Order Service ยิงมาถามราคาครับ!
    @GetMapping("/{drinkId}")
    public ResponseEntity<Drink> getDrinkById(@PathVariable("drinkId") Long drinkId) {
        Drink drink = drinkService.getDrinkById(drinkId);
        return ResponseEntity.ok(drink);
    }

}
