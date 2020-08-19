package com.example.demo.app.form;

import java.util.List;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

import com.example.demo.domain.entity.PurchaseHistory;

import lombok.Data;

@Data
public class CustomerForm {
    
    private Integer id = 0; // TODO 暫定処置

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
}