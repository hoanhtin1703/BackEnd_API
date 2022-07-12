package com.example.demo.repo;

import com.example.demo.model.Product_Model;
import com.example.demo.model.User_Model;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserReposity extends JpaRepository<User_Model, Long> {
    @Query(value ="SELECT u FROM User_Model u WHERE u.name LIKE   '%:?1%'  " )
    List<User_Model> findByNameContaining(String keyword);
}
