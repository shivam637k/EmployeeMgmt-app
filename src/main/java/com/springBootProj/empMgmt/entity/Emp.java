package com.springBootProj.empMgmt.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "emp")
@Data
public class Emp {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private String address;
    private String email;
    private String phno;
    private int salary;
}
