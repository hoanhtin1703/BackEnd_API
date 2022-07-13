package com.example.demo.repo;

import com.example.demo.model.Brand_Model;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BrandReposity extends JpaRepository<Brand_Model,Long> {
    @Query(value ="SELECT b FROM Brand_Model b WHERE b.name LIKE   '%:?1%'  " )
    List<Brand_Model> findByNameContaining(String keyword);
}
