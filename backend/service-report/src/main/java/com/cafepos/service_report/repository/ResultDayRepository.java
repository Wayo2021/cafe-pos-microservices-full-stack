package com.cafepos.service_report.repository;

import com.cafepos.service_report.entity.ResultDay;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ResultDayRepository extends JpaRepository<ResultDay, Long> {
}
