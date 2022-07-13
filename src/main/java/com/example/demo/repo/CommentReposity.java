package com.example.demo.repo;

import com.example.demo.model.Comment_Model;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CommentReposity extends JpaRepository<Comment_Model, Long> {
    @Query(value ="SELECT c FROM Comment_Model c WHERE c.comment LIKE   '%:?1%'  " )
    List<Comment_Model> findByCommentContaining(String keyword);
}
