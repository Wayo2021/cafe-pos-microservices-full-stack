package com.cafepos.service_user.service;

import com.cafepos.service_user.dto.request.CustomerRequestDTO;
import com.cafepos.service_user.entity.Customer;
import com.cafepos.service_user.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerService {

    @Autowired
    private CustomerRepository customerRepository;

    // 1. ลอจิกสมัครสมาชิก
    public Customer createCustomer(CustomerRequestDTO dto) {
        Customer customer = new Customer();
        customer.setFirstName(dto.getFirstName());
        customer.setLastName(dto.getLastName());
        customer.setPhoneNum(dto.getPhoneNum());
        customer.setTotalPoint(0); // 🌟 Business Logic: ลูกค้าใหม่เริ่มที่ 0 แต้มเสมอ

        return customerRepository.save(customer);
    }

    // 2. ลอจิกอัปเดตแต้ม (เพิ่มแต้มตอนซื้อน้ำ หรือ ลดแต้มตอนแลกรางวัล)
    public void updatePoints(Long cusId, Integer points) {
        Customer customer = customerRepository.findById(cusId)
                .orElseThrow(() -> new RuntimeException("ไม่พบลูกค้าคนนี้!"));

        customer.setTotalPoint(customer.getTotalPoint() + points);
        customerRepository.save(customer);
    }
}
