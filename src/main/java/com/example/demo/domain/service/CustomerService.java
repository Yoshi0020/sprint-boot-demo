package com.example.demo.domain.service;

import java.util.List;

import com.example.demo.domain.entity.Customer;
import com.example.demo.domain.entity.PurchaseHistory;
import com.example.demo.domain.mapper.CustomerMapper;
import com.example.demo.domain.mapper.PurchaseHistoryMapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerService {

    private CustomerMapper customerMapper;
    private PurchaseHistoryMapper historyMapper;

    @Autowired
    public CustomerService(final CustomerMapper customerMapper, final PurchaseHistoryMapper historyMapper) {
        this.customerMapper = customerMapper;
        this.historyMapper = historyMapper;
    }

    public List<Customer> findAll() {
        return this.customerMapper.findAll();
    }

    public Customer fineOnd(final Integer id) {
        return this.customerMapper.findOne(id);
    }

    public boolean Save(final Customer customer) {
        return this.customerMapper.Insert(customer);
    }

    public Integer Update(final Customer customer) {
        return this.customerMapper.Update(customer);
    }

    public Integer Delete(final Integer id) {
        return this.customerMapper.Delete(id);
    }

    public List<PurchaseHistory> findPurchaseHistories(final Integer customerId){
        return this.historyMapper.findPurchaseHistory(customerId);
    }
}