package com.example.demo.domain.service;

import java.util.List;

import com.example.demo.domain.entity.Item;
import com.example.demo.domain.mapper.ItemMapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ItemService {

    ItemMapper mapper;

    @Autowired
    public ItemService(ItemMapper mapper) {
        this.mapper = mapper;
    }

    public List<Item> findAll() {
        return mapper.findAll();
    }

    public Item findOne(final Integer id) {
        return mapper.findOne(id);
    }

    @Transactional
    public Integer save(final Item item) {
        return mapper.create(item);
    }

    @Transactional
    public Integer update(final Item item) {
        return mapper.update(item);
    }

    @Transactional
    public Integer delete(final Integer id) {
        return mapper.delete(id);
    }
}