package com.example.demo.domain.repository;

import java.util.List;

import com.example.demo.domain.entity.Item;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

@Mapper
public interface ItemMapper {
    @Select("SELECT * FROM demo.item")
    List<Item> findAll();

    @Select("SELECT * FROM demo.item WHERE id = #{id}")
    Item findOne(int id);

    @Insert("INSERT INTO demo.item(name, capacity, price, calorie, url) VALUES(#{name}, #{capacity}, #{price}, #{calorie}, #{url})")
    public int create(Item item);

    @Update("UPDATE demo.item SET name=#{name}, capacity=#{capacity}, price=#{price}, calorie=#{calorie}, url=#{url} WHERE id = #{id}")
    public int update(Item item);

    @Delete("DELETE FROM demo.item WHERE id = #{id}")
    public int delete(Item item);
}