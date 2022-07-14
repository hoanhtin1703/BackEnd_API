package com.example.demo.model;

import javax.persistence.*;

@Entity
@Table(name = "country")
public class Country_Model {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;

    @Column(name = "name")
    private String name;

    public Country_Model(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public Country_Model() {

    }


    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
