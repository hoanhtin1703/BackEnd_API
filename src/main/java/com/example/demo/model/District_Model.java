package com.example.demo.model;

import javax.persistence.*;

@Entity
@Table(name="district")
public class District_Model {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="id")
    private Long id;
    @Column(name="name")
    private String name;
    @Column(name="cost_ship")
    private int cost_ship;
    @Column(name="city_id")
    private int city_id;

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

    public int getCost_ship() {
        return cost_ship;
    }

    public void setCost_ship(int cost_ship) {
        this.cost_ship = cost_ship;
    }

    public int getCity_id() {
        return city_id;
    }

    public void setCity_id(int city_id) {
        this.city_id = city_id;
    }

    public District_Model(Long id, String name, int cost_ship, int city_id) {
        this.id = id;
        this.name = name;
        this.cost_ship = cost_ship;
        this.city_id = city_id;
    }

    public District_Model() {
    }

    @Override
    public String toString() {
        return "District_Model{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", cost_ship=" + cost_ship +
                ", city_id=" + city_id +
                '}';
    }
}
