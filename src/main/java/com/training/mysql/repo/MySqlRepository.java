package com.training.mysql.repo;

import com.training.mysql.domain.Employee;

import org.springframework.data.jpa.repository.JpaRepository;

public interface MySqlRepository extends JpaRepository<Employee, Long> {

    Employee findByEmployeeId(Long employeeId) ;
    
}
