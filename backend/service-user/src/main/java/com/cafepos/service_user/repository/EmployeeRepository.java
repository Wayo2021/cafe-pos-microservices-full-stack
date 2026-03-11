package com.cafepos.service_user.repository;

import com.cafepos.service_user.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository extends JpaRepository<Long, Employee> {
}
