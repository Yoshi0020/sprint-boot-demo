package com.example.demo.app.helper;

import com.example.demo.app.form.ItemForm;
import com.example.demo.domain.entity.Item;

import org.springframework.stereotype.Component;

@Component
public class ItemHelper {
    
    public Item convertFormToItem(final ItemForm form){
        final Item item = new Item();
        item.setId(form.getId());
        item.setName(form.getName());
        item.setCapacity(form.getCapacity());
        item.setPrice(form.getPrice());
        item.setCalorie(form.getCalorie());
        // item.setUrl(form.getUrl());

        return item;
    }

    public void setItemFormFromItem(final ItemForm form, final Item item){
        form.setId(item.getId());
        form.setName(item.getName());
        form.setCapacity(item.getCapacity());
        form.setPrice(item.getPrice());
        form.setCalorie(item.getCalorie());
        form.setUrl(item.getUrl());
    }
}