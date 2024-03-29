package com.example.demo.controller;

import com.example.demo.model.Product_Model;
import com.example.demo.repo.ProductReposity;
import com.example.demo.service.Product_ServiceIml;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("product/")
public class Product_Controller {
    @Autowired
    private ProductReposity productReposity;
    @Autowired
    private Product_ServiceIml productService;
    @GetMapping("data")
    // Hiển thị
    List<Product_Model> demo(){
        return productService.getAllProduct();
    }
//Thêm
@PostMapping("save")
public ResponseEntity<Product_Model> save(@RequestBody Product_Model product) {
    return new ResponseEntity<Product_Model>(productReposity.save(product), HttpStatus.OK);
}
    // Tìm kiếm theo id
    @GetMapping("edit/{id}")
    public ResponseEntity<Product_Model> edit(@PathVariable("id") Long id){
        Optional<Product_Model> item = productService.findProductById(id);
        return ResponseEntity.of(item);
    }
    // Chỉnh sửa
    @PutMapping("update")
    public ResponseEntity<Product_Model> updateTutorial( @RequestBody Product_Model model) {
        return new ResponseEntity<Product_Model>( productService.saveProduct(model), HttpStatus.OK);
    }
    // Xóa
    @DeleteMapping("delete/{id}")
    public ResponseEntity<Product_Model> deleteProduct(@PathVariable("id") long id){
        try {

           productService.deleteProduct(id);
                return new ResponseEntity<Product_Model>(HttpStatus.OK);
        }
        catch (Exception e) {
            // TODO: handle exception
            return new ResponseEntity<Product_Model>(HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }
//    Tìm Kiếm
    @GetMapping("search/{keyword}")
    public ResponseEntity<List<Product_Model>> search(@PathVariable("keyword") String keyword){
        return new ResponseEntity<>(productReposity.findByNameContaining(keyword), HttpStatus.OK);

    }
}
