package com.example.demo.model;

import java.io.Serializable;

public class Product_Size_Key implements Serializable {
    private String image_color;
    private int size_id;

    public Product_Size_Key() {
    }

    public Product_Size_Key(String image_color, int size_id) {
        this.image_color = image_color;
        this.size_id = size_id;
    }
}