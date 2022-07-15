package com.example.demo.repo;

import com.example.demo.model.Product_Color_Model;
import com.example.demo.model.Product_Image_Detail_Model;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Repository

public interface Product_Image_Detail_Repo extends JpaRepository<Product_Image_Detail_Model, Long> //, CrudRepository<Product_Image_Detail_Model, Long>
{

    //    @Query(value ="DELETE FROM Product_Image_Detail_Model imgdetail  WHERE (imgdetail.image_color = ?1) and (imgdetail.image_detail = ?2)")
    @Modifying
    @Transactional
    @Query(value="DELETE FROM product_image_detail p WHERE p.image_color =:id AND p.image_detail =:iamge",nativeQuery = true)
    void deleteProductColorModelByproductidAndimagecolor(@Param("id") String image_color, @Param("iamge") String image_datail);

    @Modifying
    @Transactional
    @Query(value="SELECT * FROM product_image_detail p WHERE p.image_color =:id AND p.image_detail =:iamge",nativeQuery = true)
    List<Product_Image_Detail_Model> searchProductColorDetailModelByproductidAndimagecolor(@Param("id") String image_color, @Param("iamge") String image_detail);

    @Modifying
    @Transactional
    @Query(value="UPDATE product_image_detail SET product_image_detail.image_detail =:image2 WHERE product_image_detail.image_color =:id AND product_image_detail.image_detail =:image",nativeQuery = true)
        //    @Query(value="SELECT * FROM product_color p WHERE p.product_id =:id AND p.image_color =:image",nativeQuery = true)
    void updateProductColorDeltailModelByImagedetailAndimagecolor(@Param("id") String image_color, @Param("image2") String image_detail_update, @Param("image") String image_detail);
}