package com.example.demo.repo;

import com.example.demo.model.District_Model;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DistrictReposity extends JpaRepository<District_Model,Long> {
    @Query(value ="SELECT dt FROM District_Model dt WHERE dt.name LIKE   '%:?1%'  " )
    List<District_Model> findByNameContaining(String keyword);
}
