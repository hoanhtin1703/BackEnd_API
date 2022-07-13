package com.example.demo.model;

import javax.persistence.*;

@Entity
@Table(name = "slider")

public class Slider_Model {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;

    @Column(name = "image")
    private String image;

    @Column(name = "text")
    private String text;

    @Column(name = "path")
    private String path;

    public Slider_Model(Long id, String image, String text, String path) {
        this.id = id;
        this.image = image;
        this.text = text;
        this.path = path;
    }

    public Slider_Model() {

    }


    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }
}
