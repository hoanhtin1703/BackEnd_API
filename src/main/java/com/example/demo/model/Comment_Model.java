package com.example.demo.model;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "comment")

public class Comment_Model {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;

    @Column(name = "comment")
    private String comment;

    @Column(name = "start")
    private int start;

    @Column(name = "product_id")
    private Long product_id;

    @Column(name = "user_id")
    private Long user_id;

    @Column(name = "date")
    private Date date;

    @Column(name = "parent_id")
    private Long parent_id;

    public Comment_Model(Long id, String comment, int start, Long product_id, Long user_id, Date date, Long parent_id) {
        this.id = id;
        this.comment = comment;
        this.start = start;
        this.product_id = product_id;
        this.user_id = user_id;
        this.date = date;
        this.parent_id = parent_id;
    }

    public Comment_Model() {

    }


    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public int getStart() {
        return start;
    }

    public void setStart(int start) {
        this.start = start;
    }

    public Long getProduct_id() {
        return product_id;
    }

    public void setProduct_id(Long product_id) {
        this.product_id = product_id;
    }

    public Long getUser_id() {
        return user_id;
    }

    public void setUser_id(Long user_id) {
        this.user_id = user_id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Long getParent_id() {
        return parent_id;
    }

    public void setParent_id(Long parent_id) {
        this.parent_id = parent_id;
    }
}
