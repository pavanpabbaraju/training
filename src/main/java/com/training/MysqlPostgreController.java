package com.training;

import com.training.mysql.domain.Employee;
import com.training.mysql.repo.MySqlRepository;
import com.training.postgre.repo.PostgreRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MysqlPostgreController {

    private final MySqlRepository mysqlRepo ;
    private final PostgreRepository postgreRepo ;

    @Autowired
    public MysqlPostgreController(MySqlRepository mysqlRepo, PostgreRepository postgreRepo){
        this.mysqlRepo = mysqlRepo ;
        this.postgreRepo = postgreRepo ;
    }

    @RequestMapping("/foobar/{employeeId}")
    public String fooBar(@PathVariable("employeeId") Long employeeId){
        Employee mEmployee = mysqlRepo.findByEmployeeId(employeeId);
        com.training.postgre.domain.Employee pEmployee = postgreRepo.findByEmployeeId(employeeId) ;

        return mEmployee + " " + pEmployee ;
    }
    
}
