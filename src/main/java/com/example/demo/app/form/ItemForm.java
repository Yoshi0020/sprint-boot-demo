package com.example.demo.app.form;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Min;

import com.example.demo.domain.entity.Item;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;

@Data
public class ItemForm {
    private Integer id;

    @NotBlank
    private String name;

    @NotNull
    @Min(0)
    private Integer capacity;

    @NotNull
    @Min(0)
    private Integer price;

    @NotNull
    @Min(0)
    private Integer calorie;

    private String url;

}