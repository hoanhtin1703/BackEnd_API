package com.example.demo.model;


import java.io.Serializable;


public class Product_Image_Detail_Key implements Serializable {

    private String image_color;

    private String image_detail;

    public Product_Image_Detail_Key(int product_id, String image_color) {
        this.image_color = image_color;
        this.image_detail = image_detail;
    }


}

