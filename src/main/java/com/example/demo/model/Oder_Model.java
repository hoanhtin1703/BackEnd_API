package com.example.demo.model;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name="`order`")
public class Oder_Model {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;
    @Column(name = "`date`")
    private Date date;
    @Column(name = "sender_name")
    private String sender_name;
    @Column(name = "sender_phone")
    private String sender_phone;
    @Column(name = "country")
    private String country;
    @Column(name = "city")
    private String city;
    @Column(name = "district")
    private String district;
    @Column(name = "address")
    private String address;
    @Column(name = "total")
    private long total;
    @Column(name = "user_id")
    private Long user_id;
    @Column(name = "`status`")
    private int status;
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getSender_name() {
        return sender_name;
    }

    public void setSender_name(String sender_name) {
        this.sender_name = sender_name;
    }

    public String getSender_phone() {
        return sender_phone;
    }

    public void setSender_phone(String sender_phone) {
        this.sender_phone = sender_phone;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public long getTotal() {
        return total;
    }

    public void setTotal(long total) {
        this.total = total;
    }

    public Long getUser_id() {
        return user_id;
    }

    public void setUser_id(Long user_id) {
        this.user_id = user_id;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Oder_Model{" +
                "id=" + id +
                ", date=" + date +
                ", sender_name='" + sender_name + '\'' +
                ", sender_phone='" + sender_phone + '\'' +
                ", country='" + country + '\'' +
                ", city='" + city + '\'' +
                ", district='" + district + '\'' +
                ", address='" + address + '\'' +
                ", total=" + total +
                ", user_id=" + user_id +
                ", status=" + status +
                '}';
    }



    public Oder_Model(Long id, Date date, String sender_name, String sender_phone, String country, String city, String district, String address, long total, Long user_id, int status) {
        this.id = id;
        this.date = date;
        this.sender_name = sender_name;
        this.sender_phone = sender_phone;
        this.country = country;
        this.city = city;
        this.district = district;
        this.address = address;
        this.total = total;
        this.user_id = user_id;
        this.status = status;
    }

    public Oder_Model() {
    }
}
