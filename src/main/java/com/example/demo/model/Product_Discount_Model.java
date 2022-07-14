package com.example.demo.model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "product_discount")
@IdClass(Product_Discount_Id.class)

public class Product_Discount_Model implements Serializable {
    @Id
    @Column(name = "product_id")
    private Long productId;
    @Id
    @Column(name = "discount_id")
    private Long discountId;

    @Column(name ="discount")
    private String discount;

    @Column(name ="percent")
    private int percent;

    @Column(name ="status")
    private short status;

    public Product_Discount_Model(Long productId, Long discountId, String discount, int percent, short status) {
        this.productId = productId;
        this.discountId = discountId;
        this.discount = discount;
        this.percent = percent;
        this.status = status;
    }

    public Product_Discount_Model() {

    }

    public Long getProduct_id() {
        return productId;
    }

    public void setProduct_id(Long productId) {
        this.productId = productId;
    }

    public Long getDiscount_id() {
        return discountId;
    }

    public void setDiscount_id(Long discountId) {
        this.discountId = discountId;
    }

    public String getDiscount() {
        return discount;
    }

    public void setDiscount(String discount) {
        this.discount = discount;
    }

    public int getPercent() {
        return percent;
    }

    public void setPercent(int percent) {
        this.percent = percent;
    }

    public short getStatus() {
        return status;
    }

    public void setStatus(short status) {
        this.status = status;
    }
}
