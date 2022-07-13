package com.example.demo.controller;

import com.example.demo.model.Contact_Model;
import com.example.demo.service.Product_ServiceIml;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("contact/")
public class Contact_Controller {
    @Autowired
    Product_ServiceIml contact_service;

    @GetMapping("data")
        // Hiển thị
    List<Contact_Model> demo() {
        return contact_service.getContact();
    }

    //Thêm
    @PostMapping("save")
    public ResponseEntity<Contact_Model> save(@RequestBody Contact_Model contact) {
        return new ResponseEntity<Contact_Model>(contact_service.saveContact(contact), HttpStatus.OK);

    }

    // Tìm kiếm theo id
    @GetMapping("edit/{id}")
    public ResponseEntity<Contact_Model> edit(@PathVariable("id") Long id) {
        Optional<Contact_Model> item = contact_service.findContactById(id);
        return ResponseEntity.of(item);
    }

    // Chỉnh sửa
    @PutMapping("update/{id}")
    public ResponseEntity<Contact_Model> updateTutorial(@PathVariable("id") long id, @RequestBody Contact_Model model) {
        return new ResponseEntity<Contact_Model>(contact_service.saveContact(model), HttpStatus.OK);
    }

    // Xóa
    @DeleteMapping("product/{id}")
    public ResponseEntity<Contact_Model> deleteBook(@PathVariable("id") long id) {
        try {

            contact_service.deleteUser(id);
            return new ResponseEntity<Contact_Model>(HttpStatus.OK);
        } catch (Exception e) {
            // TODO: handle exception
            return new ResponseEntity<Contact_Model>(HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }
    //    Tìm Kiếm
//    @GetMapping("search/{keyword}")
//    public ResponseEntity<List<Contact_Model>> search(@PathVariable("keyword") String keyword){
//        return new ResponseEntity<>(contact_service.findByNameContaining(keyword), HttpStatus.OK);
//}


}
