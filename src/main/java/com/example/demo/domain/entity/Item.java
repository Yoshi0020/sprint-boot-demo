package com.example.demo.domain.entity;

import java.io.Serializable;

import lombok.Data;

@Data
public class Item implements Serializable{

    private static final long serialVersionUID = 1L;
 
    private Integer id;    

    private String name;

    private Integer capacity;

    private Integer price;

    private Integer calorie;

    private String url;

}