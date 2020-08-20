package com.example.demo.app.form;

import java.util.Date;
import java.util.List;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

import com.example.demo.domain.entity.Item;
import com.example.demo.domain.entity.PurchaseHistory;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.Data;

@Data
public class CustomerForm {

    private Integer id;

    @NotBlank
    private String name;

    @NotBlank
    @Email
    private String email;

    @NotBlank
    private String password;

    @NotBlank
    private String passwordConfirm;

    private List<PurchaseHistory> purchaseHistories;

    private List<Item> items;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date fromDate;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date toDate;

    private String selectedItem;
}