package com.example.demo.controller;

import com.example.demo.model.User_Model;
import com.example.demo.repo.UserReposity;
import com.example.demo.service.Product_ServiceIml;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("user/")

public class User_Controller {

    @Autowired
    private UserReposity userReposity;
    @Autowired
    Product_ServiceIml user_service;
    // Hiển Thị
    @GetMapping("data")
    List<User_Model> getAllUser(){
        return user_service.getAllUser();

    }
    // Thêm
    @PostMapping("save")
    public ResponseEntity<User_Model> save(@RequestBody User_Model user){
        return  new ResponseEntity<User_Model>(user_service.saveUser(user), HttpStatus.OK);
    }
// Tìm Kiếm
    @GetMapping("search/{keyword}")
    public ResponseEntity<List<User_Model>> search(@PathVariable("keyword") String keyword){
        return new ResponseEntity<>(userReposity.findByNameContaining(keyword), HttpStatus.OK);

    }
// Tìm kiếm theo id
    @GetMapping("edit/{id}")
    public ResponseEntity<User_Model> edit(@PathVariable("id") Long id){
        Optional<User_Model> item = user_service.findUserById(id);
        return ResponseEntity.of(item);
    }
    // Chỉnh sửa
    @PutMapping("update")
    public ResponseEntity<User_Model> updateTutorial(@RequestBody User_Model model) {
        return new ResponseEntity<User_Model>( user_service.saveUser(model), HttpStatus.OK);
    }
    // Xóa
    @DeleteMapping("delete/{id}")
    public ResponseEntity<User_Model> deleteUser(@PathVariable("id") long id){
        try {

            user_service.deleteUser(id);
            return new ResponseEntity<User_Model>(HttpStatus.OK);
        }
        catch (Exception e) {
            // TODO: handle exception
            return new ResponseEntity<User_Model>(HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }
}
