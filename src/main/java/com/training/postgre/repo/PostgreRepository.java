package com.training.postgre.repo;

import com.training.postgre.domain.Employee;

import org.springframework.data.jpa.repository.JpaRepository;

public interface PostgreRepository extends JpaRepository<Employee,Long>{
    
    Employee findByEmployeeId(Long employeeId) ;
    
}
