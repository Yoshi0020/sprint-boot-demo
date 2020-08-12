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
    @Select("SELECT * FROM item")
    List<Item> findAll();

    @Insert("INSERT INTO item VALUES(#{id}, #{name}, #{price}, #{url})")
    public int create(Item item);

    @Update("UPDATE item SET name=#{name}, price=#{price}, url=#{url} WHERE id = #{id}")
    public int update(Item item);

    @Delete("DELETE FROM item WHERE id = #{id}")
    public int delete(Item item);
}