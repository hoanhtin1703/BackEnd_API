package com.example.demo.controller;

import com.example.demo.model.Comment_Model;
import com.example.demo.repo.CommentReposity;
import com.example.demo.service.Product_ServiceIml;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("comment/")

public class Comment_Controller {
    @Autowired
    private CommentReposity commentReposity;
    @Autowired
    Product_ServiceIml comment_service;
    // Hiển Thị
    @GetMapping("data")
    List<Comment_Model> getAllComment(){
        return comment_service.getAllComment();

    }
    // Thêm
    @PostMapping("save")
    public ResponseEntity<Comment_Model> save(@RequestBody Comment_Model comment){
        return  new ResponseEntity<Comment_Model>(comment_service.saveComment(comment), HttpStatus.OK);
    }
// Tìm kiếm
    @GetMapping("search/{keyword}")
    public ResponseEntity<List<Comment_Model>> search(@PathVariable("keyword") String keyword){
        return new ResponseEntity<>(commentReposity.findByCommentContaining(keyword), HttpStatus.OK);

    }
// Tìm kiếm theo id
    @GetMapping("edit/{id}")
    public ResponseEntity<Comment_Model> edit(@PathVariable("id") Long id){
        Optional<Comment_Model> item = comment_service.findCommentById(id);
        return ResponseEntity.of(item);
    }
    // Chỉnh sửa
    @PutMapping("update")
    public ResponseEntity<Comment_Model> updateTutorial( @RequestBody Comment_Model model) {
        return new ResponseEntity<Comment_Model>( comment_service.saveComment(model), HttpStatus.OK);
    }
    // Xóa
    @DeleteMapping("delete/{id}")
    public ResponseEntity<Comment_Model> deleteComment(@PathVariable("id") long id){
        try {

            comment_service.deleteComment(id);
            return new ResponseEntity<Comment_Model>(HttpStatus.OK);
        }
        catch (Exception e) {
            // TODO: handle exception
            return new ResponseEntity<Comment_Model>(HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }
}
