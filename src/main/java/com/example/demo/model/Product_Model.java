package com.example.demo.model;

import javax.persistence.*;
import java.util.Date;

//@Getter
//@Setter

@Entity

@Table(name = "product")
public class Product_Model {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name ="product_id")
private  Long id;
    @Column(name ="name")
    private String name;
    @Column(name ="purchase_price")
private int purchase_price;
    @Column(name ="description")
    private String  description;
    @Column(name ="brand_id")
    private int   brand_id;
    @Column(name ="status")
    private int status;
    @Column(name ="staff_id")
    private int staff_id;
    @Column(name ="price")
    private int price;
    @Column(name ="created_at")
    private Date created_at;
    @Column(name ="updated_at")
    private Date updated_at;


    public int getPurchase_price() {
        return purchase_price;
    }

    public void setPurchase_price(int purchase_price) {
        this.purchase_price = purchase_price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getBrand_id() {
        return brand_id;
    }

    public void setBrand_id(int brand_id) {
        this.brand_id = brand_id;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public int getStaff_id() {
        return staff_id;
    }

    public void setStaff_id(int staff_id) {
        this.staff_id = staff_id;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public Date getCreated_at() {
        return created_at;
    }

    public void setCreated_at(Date created_at) {
        this.created_at = created_at;
    }

    public Date getUpdated_at() {
        return updated_at;
    }

    public void setUpdated_at(Date updated_at) {
        this.updated_at = updated_at;
    }
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

//    public Product_Model(Long id, int purchase_price, String description, int brand_id, int status, int staff_id, int price, Date created_at, Date updated_at, String name) {
//        this.id = id;
//        this.purchase_price = purchase_price;
//        this.description = description;
//        this.brand_id = brand_id;
//        this.status = status;
//        this.staff_id = staff_id;
//        this.price = price;
//        this.created_at = created_at;
//        this.updated_at = updated_at;
//        this.name = name;
//    }

    public Product_Model(Long id, String name, int purchase_price, String description, int brand_id, int status, int staff_id, int price, Date created_at, Date updated_at) {
        this.id = id;
        this.name = name;
        this.purchase_price = purchase_price;
        this.description = description;
        this.brand_id = brand_id;
        this.status = status;
        this.staff_id = staff_id;
        this.price = price;
        this.created_at = created_at;
        this.updated_at = updated_at;
    }

    public Product_Model() {
    }

    @Override
    public String toString() {
        return "Product_Model{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", purchase_price=" + purchase_price +
                ", description='" + description + '\'' +
                ", brand_id=" + brand_id +
                ", status=" + status +
                ", staff_id=" + staff_id +
                ", price=" + price +
                ", created_at=" + created_at +
                ", updated_at=" + updated_at +
                '}';
    }

    //    @Override
//    public String toString() {
//        return "Employee{" +
//                "id=" + id +
//                ", firstName='" + name +
////                ", lastName='" + lastName + '\'' +
////                ", description='" + description + '\'' +
//                '}';
//    }
}
