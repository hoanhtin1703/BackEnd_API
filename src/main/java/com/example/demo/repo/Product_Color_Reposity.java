package com.example.demo.repo;

import com.example.demo.model.Product_Color_Model;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

public interface Product_Color_Reposity extends JpaRepository<Product_Color_Model, Long> {
    @Modifying
    @Transactional
    @Query(value="DELETE FROM product_color p WHERE p.product_id =:id AND p.image_color =:iamge",nativeQuery = true)
    void deleteProductColorModelByproductidAndimagecolor(@Param("id") Long product_id, @Param("iamge") String image_color);
}
