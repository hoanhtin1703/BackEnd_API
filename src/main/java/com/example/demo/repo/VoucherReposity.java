package com.example.demo.repo;

import com.example.demo.model.Voucher_Model;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface VoucherReposity extends JpaRepository<Voucher_Model, Long> {
    @Query(value ="SELECT v FROM Voucher_Model v WHERE v.code LIKE   '%:?1%'  " )
    List<Voucher_Model> findByCodeContaining(String keyword);
}
