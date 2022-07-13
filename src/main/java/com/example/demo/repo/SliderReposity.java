package com.example.demo.repo;

import com.example.demo.model.Slider_Model;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SliderReposity extends JpaRepository<Slider_Model, Long> {

    @Query(value ="SELECT s FROM Slider_Model s WHERE s.text LIKE   '%:?1%'  " )
    List<Slider_Model> findByTextContaining(String keyword);
}
