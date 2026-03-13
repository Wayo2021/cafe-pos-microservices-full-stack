package com.cafepos.service_order.service;

import com.cafepos.service_order.dto.request.OrderDetailRequestDTO;
import com.cafepos.service_order.dto.request.OrderRequestDTO;
import com.cafepos.service_order.entity.Order;
import com.cafepos.service_order.entity.OrderDetail;
import com.cafepos.service_order.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Map;

@Service
public class OrderService {

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private RestTemplate restTemplate; // 🌟 เรียกใช้เครื่องมือยิง API ที่เราเตรียมไว้ใน Config

    public Order placeOrder(OrderRequestDTO dto) {
        Order order = new Order();
        order.setDate(LocalDate.now());
        order.setTime(LocalTime.now());
        order.setEmpId(dto.getEmpId());
        order.setCusId(dto.getCusId());

        double totalPrice = 0.0;
        order.setOrderDetails(new ArrayList<>());

        for (OrderDetailRequestDTO detailDTO : dto.getOrderDetails()) {
            OrderDetail detail = new OrderDetail();
            detail.setDrinkId(detailDTO.getDrinkId());
            detail.setAmount(detailDTO.getAmount());

            // 🌐 ยิง API ของจริง! ไปถามราคาจาก Product Service
            double pricePerCup = fetchDrinkPriceFromProductService(detailDTO.getDrinkId());

            detail.setSubTotal(pricePerCup * detailDTO.getAmount());
            detail.setOrder(order);

            totalPrice += detail.getSubTotal();
            order.getOrderDetails().add(detail);
        }

        order.setTotalPrice(totalPrice);

        int earnedPoint = (int) (totalPrice / 50);
        order.setEarnedPoint(earnedPoint);

        Order savedOrder = orderRepository.save(order);

        // 🌐 ยิง API ของจริง! ไปบอก User Service ให้บวกแต้ม
        if (dto.getCusId() != null && earnedPoint > 0) {
            addPointToCustomer(dto.getCusId(), earnedPoint);
        }

        return savedOrder;
    }

    // ==========================================
    // 🚀 ส่วนยิง API ข้าม Service ของจริง
    // ==========================================

    private double fetchDrinkPriceFromProductService(Long drinkId) {
        // ยิง GET ไปที่พอร์ต 8082 (Product Service)
        String url = "http://localhost:8082/api/drinks/" + drinkId;

        // รับค่ากลับมาเป็น Map (JSON ก้อนนั้นนั่นเอง)
        Map<String, Object> response = restTemplate.getForObject(url, Map.class);

        if (response != null && response.get("drinkPrice") != null) {
            return Double.parseDouble(response.get("drinkPrice").toString());
        }
        throw new RuntimeException("ไม่สามารถดึงราคาจาก Product Service ได้!");
    }

    private void addPointToCustomer(Long cusId, Integer point) {
        // ยิง PUT ไปที่พอร์ต 8081 (User Service)
        String url = "http://localhost:8081/api/customers/" + cusId + "/points?points=" + point;

        // สั่งอัปเดต โดยไม่ได้คาดหวังผลลัพธ์อะไรกลับมาเป็นพิเศษ (ส่ง null ไปเป็น Body)
        restTemplate.put(url, null);
    }
}
