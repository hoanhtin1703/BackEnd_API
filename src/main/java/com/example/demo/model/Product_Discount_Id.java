package com.example.demo.model;

import java.io.Serializable;

public class Product_Discount_Id implements Serializable {

    private Long productId;

    private Long discountId;

    public Product_Discount_Id(Long productId, Long discountId) {
        this.productId = productId;
        this.discountId = discountId;
    }

    public Product_Discount_Id() {
    }
}
