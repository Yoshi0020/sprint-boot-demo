package com.example.demo.app.form;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Min;

import com.example.demo.domain.entity.Item;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;

@Data
public class ItemForm {
    private int id;

    @Autowired
    protected MessageSource messageSource;

    @NotBlank
    private String name;

    @Min(value = 0, message = "0以上の値を設定してください。")
    @Pattern(regexp = "[0-9]+", message = "内容量は数値で設定してください。")
    private String capacity;

    @Min(value = 0, message = "0以上の値を設定してください。")
    @Pattern(regexp = "[0-9]+", message = "金額は数値で設定してください。")
    private String price;

    @Pattern(regexp = "[0-9]+", message = "カロリーは数値で設定してください。")
    private String calorie;

    private String url;

    public Item createItem() {
        Item item = new Item();
        item.setName(name);
        ;
        item.setCapacity(Integer.parseInt(capacity));
        item.setPrice(Integer.parseInt(price));
        item.setCalorie(Integer.parseInt(calorie));

        return item;
    }
}