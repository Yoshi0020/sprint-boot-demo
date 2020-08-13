package com.example.demo.domain.entity;

import java.io.Serializable;

import lombok.Data;

@Data
public class Item implements Serializable{

    private static final long serialVersionUID = 1L;
 
    private String id;    

    private String name;

    private int capacity;

    private int price;

    private int calorie;

    private String url;

}