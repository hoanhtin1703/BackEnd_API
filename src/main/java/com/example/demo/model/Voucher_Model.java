package com.example.demo.model;

import javax.persistence.*;

@Entity
@Table(name = "voucher")

public class Voucher_Model {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;

    @Column(name = "code")
    private String code;

    @Column(name = "price")
    private int price;

    @Column(name = "user_id")
    private Long user_id;

    public Voucher_Model(Long id, String code, int price, Long user_id) {
        this.id = id;
        this.code = code;
        this.price = price;
        this.user_id = user_id;
    }

    public Voucher_Model() {

    }


    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public Long getUser_id() {
        return user_id;
    }

    public void setUser_id(Long user_id) {
        this.user_id = user_id;
    }
}
