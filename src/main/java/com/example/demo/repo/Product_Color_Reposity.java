package com.example.demo.repo;

import com.example.demo.model.Product_Color_Model;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface Product_Color_Reposity extends JpaRepository<Product_Color_Model, Long> {
    @Modifying
    @Transactional
    @Query(value="DELETE FROM product_color p WHERE p.product_id =:id AND p.image_color =:iamge",nativeQuery = true)
    void deleteProductColorModelByproductidAndimagecolor(@Param("id") Long product_id, @Param("iamge") String image_color);

    @Modifying
    @Transactional
    @Query(value="SELECT * FROM product_color p WHERE p.product_id =:id AND p.image_color =:iamge",nativeQuery = true)
    List<Product_Color_Model> searchProductColorModelByproductidAndimagecolor(@Param("id") Long product_id, @Param("iamge") String image_color);


    //UPDATE `sneaker`.`product_color` SET `image_color` = 'green' WHERE (`product_id` = '5') and (`image_color` = 'pink');
    @Modifying
    @Transactional
    @Query(value="UPDATE product_color SET product_color.image_color =:image2 WHERE product_color.product_id =:id AND product_color.image_color =:image",nativeQuery = true)
    void updateProductColorModelByproductidAndimagecolor(@Param("id") Long product_id, @Param("image2") String image_color_update, @Param("image") String image_color);
@Modifying
@Transactional
    @Query(value = "SELECT distinct product.name FROM product INNER JOIN product_color ON product.product_id =:id",nativeQuery = true )
    Object showProductName(@Param("id") int id);
    @Modifying
    @Transactional
    @Query(value = "SELECT product.product_id,product.name as image_name , product_color.image_color FROM  product INNER JOIN  product_color ON product.product_id =  product_color.product_id",nativeQuery = true )
    List<Product_Color_Model>findAllProductColor();

}
