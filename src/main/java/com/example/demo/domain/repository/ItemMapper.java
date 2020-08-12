package com.example.demo.domain.repository;

import java.util.List;

import com.example.demo.domain.entity.Item;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface ItemMapper {
    @Select("SELECT * FROM item")
    List<Item> findAll();
}