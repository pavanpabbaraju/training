package com.training.mysql.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "employees")
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id ;

    private Long employeeId ;
    private String firstname ;
    private String lastname ;

    //constructor
    Employee(){}
    //parameterized constructor
    Employee(Long employeeId,String firstname,String lastname){
        this.employeeId = employeeId ;
        this.firstname = firstname ;
        this.lastname = lastname ;
    }
}