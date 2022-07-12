package com.example.demo.model;


import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "product_color") //Product Color Model
@IdClass(ColorId.class)
public class Product_Color_Model implements Serializable {

    @Id
    @Column(name = "product_id")
    private int product_id;
    @Id
    @Column(name = "image_color")
    private String image_color;

    public Product_Color_Model() {
    }

    public Product_Color_Model(int product_id, String image_color) {
        this.product_id = product_id;
        this.image_color = image_color;
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
