package com.example.demo.model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "product_color")
@IdClass(Product_Color_Id.class)

public class Product_Color_Model implements Serializable {
//
    @Id
    @Column(name = "product_id")
    private int product_id;
    @Id
    @Column(name = "image_color")
    private String image_color;

    @Transient
    private  String image_name;

    public String getImage_name() {
        return product_modelSet.getName();
    }

//    public void setImage_name(String image_name) {
//        this.image_name = image_name;
//    }
// Join Column
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "product_id", insertable = false, updatable = false )
    private Product_Model product_modelSet ;
    public Product_Color_Model(int product_id, String image_color) {
        this.product_id = product_id;
        this.image_color = image_color;
    }
    public Product_Color_Model() {
    }

    public int getProduct_id() {
        return product_id;
    }

    public void setProduct_id(int product_id) {
        this.product_id = product_id;
    }

    public String getImage_color() {
        return image_color;
    }

    public void setImage_color(String image_color) {
        this.image_color = image_color;
    }
}
