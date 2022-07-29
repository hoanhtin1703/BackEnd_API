package com.example.demo.repo;

import com.example.demo.model.Product_Discount_Model;
import com.example.demo.model.Product_Model;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

public interface Product_Discount_Reposity extends JpaRepository<Product_Discount_Model, Long> {
    @org.springframework.data.jdbc.repository.query.Query(value ="SELECT pd FROM Product_Discount_Model pd WHERE pd.discount LIKE   '%:?1%'  " )
    List<Product_Discount_Model> findByDiscountContaining(String keyword);

    @Modifying
    @Transactional
    @Query(value = "DELETE FROM product_discount pd WHERE pd.product_id = :product_id AND pd.discount_id = :discount_id", nativeQuery=true)
    void deleteProductDiscountByProductIdAndDiscountId(@Param("product_id") Long product_id, @Param("discount_id") Long discount_id);

    @Modifying
    @Transactional
    @Query(value = "SELECT * FROM product_discount pd WHERE pd.product_id = :product_id AND pd.discount_id = :discount_id", nativeQuery=true)
    List<Product_Discount_Model> findByProductIdAndDiscountId(@Param("product_id") Long product_id, @Param("discount_id") Long discount_id);

}
