package com.example.demo.repo;

import com.example.demo.model.Brand_Model;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BrandReposity extends JpaRepository<Brand_Model,Long> {

}
