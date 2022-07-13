package com.example.demo.repo;

import com.example.demo.model.Contact_Model;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ContactReposity extends JpaRepository<Contact_Model,Long> {
//    @Query(value ="SELECT o FROM Contact_Model WHERE o WHERE o.name LIKE   '%:?1%'  " )
//    List<Contact_Model> findByNameContaining(String keyword);
}
