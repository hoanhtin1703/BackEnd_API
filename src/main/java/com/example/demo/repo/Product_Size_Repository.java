package com.example.demo.repo;

import com.example.demo.model.Product_Size_Model;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface Product_Size_Repository extends JpaRepository<Product_Size_Model, Long> {

    @Modifying
    @Transactional
    @Query(value="SELECT * FROM product_size p WHERE p.image_color =:image AND p.size_id =:id",nativeQuery = true)
    List<Product_Size_Model> searchProductSizeModelByImageColorAndSizeId(@Param("image") String image_color, @Param("id") int size_id);

    @Modifying
    @Transactional
    @Query(value="DELETE FROM product_size p WHERE p.image_color =:image AND p.size_id =:id",nativeQuery = true)
    void deleteProductSizeModelByImageColorAndSizeId(@Param("image") String image_color, @Param("id") int size_id);

    @Modifying
    @Transactional
    //UPDATE `sneaker`.`product_size` SET `quantity` = '23' WHERE (`image_color` = 'xanhof6') and (`size_id` = '40');
    @Query(value="UPDATE product_size SET product_size.quantity =:quantity WHERE product_size.size_id =:id AND product_size.image_color =:image",nativeQuery = true)
    void updateQuantity(@Param("image") String image_color, @Param("quantity") int quantity, @Param("id") int size_id);

    @Modifying
    @Transactional
    @Query(value="UPDATE product_size SET product_size.sell =:sell WHERE product_size.size_id =:id AND product_size.image_color =:image",nativeQuery = true)
    void updateSold(@Param("image") String image_color, @Param("sell") int sell, @Param("id") int size_id);
}

