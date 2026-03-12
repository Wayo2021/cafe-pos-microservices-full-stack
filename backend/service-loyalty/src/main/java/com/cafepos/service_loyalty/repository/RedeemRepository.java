package com.cafepos.service_loyalty.repository;

import com.cafepos.service_loyalty.entity.Redeem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RedeemRepository extends JpaRepository<Redeem, Long> {
}
