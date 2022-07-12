package com.example.demo.model;

import javax.persistence.*;

//@Getter
//@Setter

@Entity
@Table(name = "student")
public class Product_Model {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name ="id")
private  Long id;
    @Column(name ="name")

private String name;
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

    public Product_Model(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public Product_Model() {
    }
    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", firstName='" + name +
//                ", lastName='" + lastName + '\'' +
//                ", description='" + description + '\'' +
                '}';
    }
}
