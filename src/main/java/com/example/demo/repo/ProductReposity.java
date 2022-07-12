package com.example.demo.repo;

import com.example.demo.model.Product_Model;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductReposity extends JpaRepository<Product_Model,Long> {
    @Query(value ="SELECT p FROM Product_Model p WHERE p.name LIKE   '%:?1%'  " )
    List<Product_Model> findByNameContaining( String keyword);

}
