package com.example.demo.domain.mapper;

import java.util.List;

import com.example.demo.domain.entity.PurchaseHistory;
import com.example.demo.domain.model.manage.customer.HistorySearchCriteria;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface PurchaseHistoryMapper {

    public List<PurchaseHistory> findPurchaseHistory(@Param("customerId") Integer customerId,
            @Param("criteria") HistorySearchCriteria criteria);
            
    @Insert("INSERT INTO demo.purchase_history(purchase_at, seq, customer_id, item_id, number, payment) VALUES(#{purchaseAt}, #{seq}, #{customerId}, #{itemId}, #{number}, #{payment})")
    public Boolean Insert(final PurchaseHistory history);

    @Delete("DELETE FROM demo.purchase_history WHERE customer_id = #{customerId}")
    public Integer DeleteFor(final Integer customerId);
}