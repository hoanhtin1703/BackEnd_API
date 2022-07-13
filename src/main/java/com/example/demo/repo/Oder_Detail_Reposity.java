package com.example.demo.repo;

import com.example.demo.model.Oder_Detail_Model;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Oder_Detail_Reposity extends JpaRepository<Oder_Detail_Model,Long> {
//    @Query(value ="SELECT o FROM Order_Model WHERE o WHERE o.name LIKE   '%:?1%'  " )
//    List<Oder_Model> findByNameContaining(String keyword);

}
