package com.example.demo.domain.service;

import java.util.List;

import com.example.demo.domain.entity.Item;
import com.example.demo.domain.repository.ItemMapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ItemService {
    @Autowired
    ItemMapper mapper;

    public List<Item> findAll()
    {
        return mapper.findAll();
    }

}