package com.example.demo.domain.mapper;

import java.util.List;

import com.example.demo.domain.entity.Customer;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.annotations.Delete;

@Mapper
public interface CustomerMapper {

    @Select("SELECT * FROM demo.customer ORDER BY id")
    public List<Customer> findAll();

    @Select("SELECT * FROM demo.customer WHERE id = #{id}")
    public Customer findOne(final Integer id);

    @Insert("INSERT INTO demo.customer(name, email, password) VALUES(#{name}, #{email}, #{password})")
    public boolean Insert(final Customer customer);

    @Update("UPDATE demo.customer SET name=#{name}, email=#{email}, password=#{password} WHERE id = #{id}")
    public Integer Update(final Customer customer);

    @Delete("DELETE FROM demo.customer WHERE id = #{id}")
    public Integer Delete(final Integer id);
}