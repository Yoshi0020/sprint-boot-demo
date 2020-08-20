package com.example.demo.app.helper;

import com.example.demo.app.form.CustomerForm;
import com.example.demo.domain.entity.Customer;
import com.example.demo.domain.model.manage.customer.HistorySearchCriteria;

import org.springframework.stereotype.Component;

@Component
public class CustomerHelper {

    public Customer convertFormToItem(final CustomerForm form) {
        final Customer customer = new Customer();

        customer.setId(form.getId());
        customer.setName(form.getName());
        customer.setEmail(form.getEmail());
        customer.setPassword(form.getPassword());

        return customer;
    }

    public void setItemFormFromItem(final CustomerForm form, final Customer customer) {
        form.setId(customer.getId());
        form.setName(customer.getName());
        form.setEmail(customer.getEmail());
        form.setPassword(customer.getPassword());
        form.setPasswordConfirm(customer.getPassword());
    }

    public HistorySearchCriteria createHistorySearchCriteriaFromCustomForm(final CustomerForm form) {
        final HistorySearchCriteria criteria = new HistorySearchCriteria();
        criteria.setFromDate(form.getFromDate());
        criteria.setToDate(form.getToDate());
        if (form.getSelectedItem() == null || form.getSelectedItem().isEmpty() == true) {
            criteria.setSelectedItem(null);
        } else {
            criteria.setSelectedItem(Integer.parseInt(form.getSelectedItem()));
        }

        return criteria;
    }
}