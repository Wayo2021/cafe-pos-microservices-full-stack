package com.cafepos.service_order.repository;

import com.cafepos.service_order.entity.OrderDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderDetailRepository extends JpaRepository<Long, OrderDetail> {
}
