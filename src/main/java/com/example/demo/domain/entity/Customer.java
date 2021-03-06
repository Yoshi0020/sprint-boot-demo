package com.example.demo.domain.entity;

import java.io.Serializable;

import lombok.Data;

@Data
public class Customer implements Serializable {
   
    private static final long serialVersionUID = 1L;

    private Integer id;

    private String name;

    private String password;

    private String email;
}