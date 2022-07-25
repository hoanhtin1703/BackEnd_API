package com.example.demo.model;

import javax.persistence.Entity;
import javax.persistence.IdClass;
import javax.persistence.*;
@Entity
@IdClass(Product_Size_Key.class)
@Table(name = "product_size")
public class Product_Size_Model {
    @Id
    @Column(name="image_color")
    private String image_color;

    @Id
    @Column(name ="size_id")
    private int size_id;

    @Column(name = "quantity")
    private int quantity;

    @Column(name = "sell")
    private int sell;

    public Product_Size_Model() {
    }

    public Product_Size_Model(String image_color, int size_id, int quantity, int sell) {
        this.image_color = image_color;
        this.size_id = size_id;
        this.quantity = quantity;
        this.sell = sell;
    }

    public String getImage_color() {
        return image_color;
    }

    public void setImage_color(String image_color) {
        this.image_color = image_color;
    }

    public int getSize_id() {
        return size_id;
    }

    public void setSize_id(int size_id) {
        this.size_id = size_id;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getSell() {
        return sell;
    }
//
    public void setSell(int sell) {
        this.sell = sell;
    }
}