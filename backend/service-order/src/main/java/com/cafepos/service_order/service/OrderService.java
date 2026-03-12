package com.cafepos.service_order.service;

import com.cafepos.service_order.dto.request.OrderDetailRequestDTO;
import com.cafepos.service_order.dto.request.OrderRequestDTO;
import com.cafepos.service_order.entity.Order;
import com.cafepos.service_order.entity.OrderDetail;
import com.cafepos.service_order.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;

@Service
public class OrderService {
    @Autowired
    private OrderRepository orderRepository;

    public Order placeOrder(OrderRequestDTO dto) {
        Order order = new Order();
        order.setDate(LocalDate.now()); // เซตวันที่ปัจจุบัน
        order.setTime(LocalTime.now()); // เซตเวลาปัจจุบัน
        order.setEmpId(dto.getEmpId());
        order.setCusId(dto.getCusId());

        double totalPrice = 0.0;
        order.setOrderDetails(new ArrayList<>());

        // วนลูปคิดเงินทีละแก้ว
        for (OrderDetailRequestDTO detailDTO : dto.getOrderDetails()) {
            OrderDetail detail = new OrderDetail();
            detail.setDrinkId(detailDTO.getDrinkId());
            detail.setAmount(detailDTO.getAmount());

            // 🌐 [จำลอง] ยิง API ไปถามราคาแก้วนี้ จาก Product Service
            double pricePerCup = fetchDrinkPriceFromProductService(detailDTO.getDrinkId());

            detail.setSubTotal(pricePerCup * detailDTO.getAmount());
            detail.setOrder(order); // 🔗 Physical FK: ผูกลูกเข้ากับแม่

            totalPrice += detail.getSubTotal();
            order.getOrderDetails().add(detail);
        }

        order.setTotalPrice(totalPrice);

        // 🌟 Business Logic: ทุกๆ 50 บาท ได้ 1 แต้ม
        int earnedPoint = (int) (totalPrice / 50);
        order.setEarnedPoint(earnedPoint);

        Order savedOrder = orderRepository.save(order);

        // 🌐 [จำลอง] ยิง API ไปบอก User Service ให้บวกแต้มให้ลูกค้าคนนี้
        if (dto.getCusId() != null && earnedPoint > 0) {
            addPointToCustomer(dto.getCusId(), earnedPoint);
        }

        return savedOrder;
    }

    // --- Mock Methods สำหรับการยิง API ข้าม Service ---
    private double fetchDrinkPriceFromProductService(Long drinkId) {
        return 65.0; // สมมติว่ายิง API ไปถามแล้วได้ราคา 65 บาทกลับมา
    }

    private void addPointToCustomer(Long cusId, Integer point) {
        // โค้ดยิง API ยิงไปที่ POST /api/customers/{cusId}/add-point
    }
}
