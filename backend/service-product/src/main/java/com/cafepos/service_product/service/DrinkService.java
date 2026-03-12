package com.cafepos.service_product.service;

import com.cafepos.service_product.dto.request.DrinkRequestDTO;
import com.cafepos.service_product.entity.Drink;
import com.cafepos.service_product.repository.DrinkRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DrinkService {

    @Autowired
    private DrinkRepository drinkRepository;

    // ลอจิกสร้างเมนูน้ำใหม่
    public Drink createDrink(DrinkRequestDTO dto) {
        Drink drink = new Drink();
        drink.setDrinkName(dto.getDrinkName());
        drink.setDrinkPrice(dto.getDrinkPrice());
        drink.setDrinkType(dto.getDrinkType());

        return drinkRepository.save(drink);
    }

    // ดึงข้อมูลไปให้ Order Service คำนวณราคา
    public Drink getDrinkById(Long drinkId) {
        return drinkRepository.findById(drinkId)
                .orElseThrow(() -> new RuntimeException("ไม่มีเมนูน้ำนี้ในระบบ!"));
    }

}
