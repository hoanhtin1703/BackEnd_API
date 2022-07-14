package com.example.demo.model;

import javax.persistence.*;

@Entity
@Table(name="city")
public class City_Model {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="id")
    private Long id;
    @Column(name="name")
    private String name;
    @Column(name="country_id")
    private int country_id;
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

    public int getCountry_id() {
        return country_id;
    }

    public void setCountry_id(int country_id) {
        this.country_id = country_id;
    }

    public City_Model(Long id, String name, int country_id) {
        this.id = id;
        this.name = name;
        this.country_id = country_id;
    }

    public City_Model() {
    }

    @Override
    public String toString() {
        return "City_Model{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", country_id=" + country_id +
                '}';
    }




}
