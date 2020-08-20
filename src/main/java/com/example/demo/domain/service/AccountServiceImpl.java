package com.example.demo.domain.service;

import com.example.demo.domain.entity.Account;
import com.example.demo.domain.mapper.AccountMapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class AccountServiceImpl implements UserDetailsService {

    private AccountMapper mapper;

    @Autowired
    public AccountServiceImpl(final AccountMapper mapper) {
        this.mapper = mapper;
    }

    @Override
    public UserDetails loadUserByUsername(String eMail) throws UsernameNotFoundException {
        if (eMail == null || eMail.isEmpty() == true) {
            throw new IllegalArgumentException("eMailの値が不正です。");
        }

        final Account account = this.mapper.findByMailAddress(eMail);
        if (account == null) {
            throw new IllegalStateException("アカウント情報の取得に失敗しました。");
        }
        
        return account;
    }

}