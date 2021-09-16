package com.training.postgre.domain;

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
    public Employee(){}
    //parameterized constructor
    public Employee(Long employeeId,String firstname,String lastname){
        this.employeeId = employeeId ;
        this.firstname = firstname ;
        this.lastname = lastname ;
    }
}
