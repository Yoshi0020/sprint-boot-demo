package com.example.demo.domain.entity;

import java.time.LocalDate;

public class PurchaseHistory {

    public Integer id;

    public LocalDate purchaseAt;

    public Integer seq;

    public Integer customerId;

    public Integer itemId;

    public Integer number;

    public Integer payment;

    public Item item;
}