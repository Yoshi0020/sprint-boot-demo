package com.example.demo.domain.model.manage.customer;

import java.util.Date;

import lombok.Data;

@Data
public class HistorySearchCriteria {

    private Date fromDate;

    private Date toDate;

    private Integer selectedItem;
}