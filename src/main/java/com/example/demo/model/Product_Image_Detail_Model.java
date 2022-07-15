package com.example.demo.model;

import javax.persistence.*;

@Entity
@IdClass(Product_Image_Detail_Key.class)
//@NamedQuery(name="product_image_detail.deleteProductColorDetail" , query="delete from product_image_detail.product_color where product_image_detail.image_color = ?1 and product_image_detail.image_detail = ?2")
@Table(name = "product_image_detail")
public class Product_Image_Detail_Model {
    @Id
    @Column(name = "image_color")
    private String image_color;
    @Id
    @Column(name = "image_detail")
    private String image_detail;

    public Product_Image_Detail_Model() {
    }

    public String getImage_color() {
        return image_color;
    }

    public void setImage_color(String image_color) {
        this.image_color = image_color;
    }

    public String getImage_detail() {
        return image_detail;
    }

    public void setImage_detail(String image_detail) {
        this.image_detail = image_detail;
    }

    public Product_Image_Detail_Model(String image_color, String image_detail) {
        this.image_color = image_color;
        this.image_detail = image_detail;
    }
}
