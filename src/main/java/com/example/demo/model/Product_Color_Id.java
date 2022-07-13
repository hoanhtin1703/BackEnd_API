package com.example.demo.model;

import java.io.Serializable;

public class Product_Color_Id implements Serializable {

    private int product_id;

    private String image_color;

    public Product_Color_Id(int product_id, String image_color) {
        this.product_id = product_id;
        this.image_color = image_color;
    }

    public Product_Color_Id() {
    }
}
