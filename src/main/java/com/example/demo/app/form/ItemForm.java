package com.example.demo.app.form;

import lombok.Data;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;

import com.example.demo.domain.entity.Item;

@Data
public class ItemForm {
    private int id;    

    @NotBlank
    private String name;

    @Min(0)
    private int capacity;

    @Min(0)
    private int price;

    @Min(0)
    private int calorie;

    private String url;

    public Item createItem(){
        Item item = new Item();
        item.setName(name);;
        item.setCapacity(capacity);
        item.setPrice(price);
        item.setCalorie(calorie);

        return item;
    }
}