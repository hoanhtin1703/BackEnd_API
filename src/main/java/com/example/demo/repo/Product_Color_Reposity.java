package com.example.demo.repo;

import com.example.demo.model.Product_Color_Model;
import org.springframework.data.jpa.repository.JpaRepository;

public interface Product_Color_Reposity extends JpaRepository<Product_Color_Model, Long> {
}
