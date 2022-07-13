package com.example.demo.repo;

import com.example.demo.model.Oder_Model;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface OderReposity extends JpaRepository<Oder_Model,Long> {
//    @Query(value ="SELECT o FROM Order_Model WHERE o WHERE o.name LIKE   '%:?1%'  " )
//    List<Oder_Model> findByNameContaining(String keyword);

}
