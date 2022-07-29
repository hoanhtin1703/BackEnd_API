package com.example.demo.repo;

import com.example.demo.model.Oder_Detail_Model;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface Oder_Detail_Reposity extends JpaRepository<Oder_Detail_Model,Long> {
    @Query(value ="SELECT od FROM Oder_Detail_Model od WHERE od.productName LIKE   '%:?1%'  " )
    List<Oder_Detail_Model> findByProductNameContaining(String keyword);

}
