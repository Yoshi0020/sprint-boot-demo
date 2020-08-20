package com.example.demo.domain.service;

import java.util.List;

import com.example.demo.domain.entity.Customer;
import com.example.demo.domain.entity.Item;
import com.example.demo.domain.entity.PurchaseHistory;
import com.example.demo.domain.mapper.CustomerMapper;
import com.example.demo.domain.mapper.ItemMapper;
import com.example.demo.domain.mapper.PurchaseHistoryMapper;
import com.example.demo.domain.model.manage.customer.HistorySearchCriteria;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerService {

    private CustomerMapper customerMapper;
    private ItemMapper itemMapper;
    private PurchaseHistoryMapper historyMapper;

    @Autowired
    public CustomerService(final CustomerMapper customerMapper, final ItemMapper itemMapper,
            final PurchaseHistoryMapper historyMapper) {
        this.customerMapper = customerMapper;
        this.itemMapper = itemMapper;
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

    public List<PurchaseHistory> findPurchaseHistories(final Integer customerId, final HistorySearchCriteria criteria) {
        return this.historyMapper.findPurchaseHistory(customerId, criteria);
    }

    public List<Item> findAllItems(){
        return this.itemMapper.findAll();
    }
}