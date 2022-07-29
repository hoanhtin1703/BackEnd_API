package com.example.demo.service.dtos;


import javax.persistence.Column;

public class ProductColorDto {
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

    public String getImage_name() {
        return image_name;
    }

    public void setImage_name(String image_name) {
        this.image_name = image_name;
    }

    public ProductColorDto(int product_id, String image_color, String image_name) {
        this.product_id = product_id;
        this.image_color = image_color;
        this.image_name = image_name;
    }

    public ProductColorDto() {
    }
@Column(name = "product_id")
    private  int product_id;
    @Column(name = "image_color")
    private  String image_color;
    @Column(name = "image_name")
    private  String image_name;

}
