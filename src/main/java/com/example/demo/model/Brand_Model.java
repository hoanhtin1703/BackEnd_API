package com.example.demo.model;

import javax.persistence.*;

@Entity
@Table(name = "brand")
public class Brand_Model {
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

    public Brand_Model(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    @Override
    public String toString() {
        return "Brand_Model{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }

    public Brand_Model() {
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;
    @Column(name = "name")
    private String name;
}
