package com.example.demo.domain.mapper;

import com.example.demo.domain.entity.Account;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface AccountMapper {
    
    @Select("SELECT * FROM demo.account WHERE email = ${email}")
    public Account findByMailAddress(final String eMail);
}