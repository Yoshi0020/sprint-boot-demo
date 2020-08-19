package com.example.demo.app.helper;

import com.example.demo.app.form.CustomerForm;
import com.example.demo.domain.entity.Customer;

import org.springframework.stereotype.Component;

@Component
public class CustomerHelper {

    public Customer convertFormToItem(final CustomerForm form){
        final Customer customer = new Customer();

        customer.setId(form.getId());
        customer.setName(form.getName());  
        customer.setEmail(form.getEmail());
        customer.setPassword(form.getPassword());

        return customer;
    } 

    public void setItemFormFromItem(final CustomerForm form, final Customer customer){
        form.setId(customer.getId());
        form.setName(customer.getName());
        form.setEmail(customer.getEmail());
        form.setPassword(customer.getPassword());
        form.setPasswordConfirm(customer.getPassword());
    }
}