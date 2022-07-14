package com.example.demo.repo;

import com.example.demo.model.Country_Model;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CountryReposity extends JpaRepository<Country_Model, Long> {
    @Query(value ="SELECT ct FROM Country_Model ct WHERE ct.name LIKE   '%:?1%'  " )
    List<Country_Model> findByNameContaining(String keyword);
}
