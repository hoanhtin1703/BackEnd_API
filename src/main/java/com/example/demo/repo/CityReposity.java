package com.example.demo.repo;

import com.example.demo.model.City_Model;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CityReposity extends JpaRepository<City_Model,Long> {
    @Query(value ="SELECT ct FROM City_Model ct WHERE ct.name LIKE   '%:?1%'  " )
    List<City_Model> findByNameContaining(String keyword);
}
