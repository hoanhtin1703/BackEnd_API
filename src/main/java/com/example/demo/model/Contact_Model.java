package com.example.demo.model;

import javax.persistence.*;

@Entity
@Table(name="contact")
public class Contact_Model {
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getLogo() {
        return logo;
    }

    public void setLogo(String logo) {
        this.logo = logo;
    }

    public String getFb_link() {
        return fb_link;
    }

    public void setFb_link(String fb_link) {
        this.fb_link = fb_link;
    }

    public String getInstagram_link() {
        return instagram_link;
    }

    public void setInstagram_link(String instagram_link) {
        this.instagram_link = instagram_link;
    }

    public String getYt_link() {
        return yt_link;
    }

    public void setYt_link(String yt_link) {
        this.yt_link = yt_link;
    }

    public String getTwitter_link() {
        return twitter_link;
    }

    public void setTwitter_link(String twitter_link) {
        this.twitter_link = twitter_link;
    }

    public Contact_Model() {
    }

    @Override
    public String toString() {
        return "Contact_Model{" +
                "id=" + id +
                ", email='" + email + '\'' +
                ", phone='" + phone + '\'' +
                ", address='" + address + '\'' +
                ", logo='" + logo + '\'' +
                ", fb_link='" + fb_link + '\'' +
                ", instagram_link='" + instagram_link + '\'' +
                ", yt_link='" + yt_link + '\'' +
                ", twitter_link='" + twitter_link + '\'' +
                '}';
    }

    public Contact_Model(Long id, String email, String phone, String address, String logo, String fb_link, String instagram_link, String yt_link, String twitter_link) {
        this.id = id;
        this.email = email;
        this.phone = phone;
        this.address = address;
        this.logo = logo;
        this.fb_link = fb_link;
        this.instagram_link = instagram_link;
        this.yt_link = yt_link;
        this.twitter_link = twitter_link;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;
    @Column(name = "email")
    private String email;
    @Column(name = "phone")
    private String phone;
    @Column(name = "address")
    private String address;
    @Column(name = "logo")
    private String logo;
    @Column(name = "fb_link")
    private String fb_link;
    @Column(name = "instagram_link")
    private String instagram_link;
    @Column(name = "yt_link")
    private String yt_link;
    @Column(name = "twitter_link")
    private String twitter_link;


}
