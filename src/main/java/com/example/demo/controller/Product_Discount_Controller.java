package com.example.demo.controller;

import com.example.demo.model.Product_Discount_Model;
import com.example.demo.repo.Product_Discount_Reposity;
import com.example.demo.service.Product_ServiceIml;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("product/discount/")

public class Product_Discount_Controller {
    @Autowired
    private Product_Discount_Reposity productReposity;
    @Autowired
    private Product_ServiceIml productService;

    // Get all
    @GetMapping("data")
    public List<Product_Discount_Model> getAllProductDiscount(){
        return productService.getAllProductDiscount();
    }

    // Thêm
    @PostMapping("save")
    public Product_Discount_Model addProductDiscount(@RequestBody Product_Discount_Model product_discount_model){

        return (Product_Discount_Model)  productService.addProductDiscount(product_discount_model);
    }

    // Tìm kiếm
    @GetMapping("search/{keyword}")
    public ResponseEntity<List<Product_Discount_Model>> search(@PathVariable("keyword") String keyword){
        return new ResponseEntity<>(productReposity.findByDiscountContaining(keyword), HttpStatus.OK);

    }

    // Xoá
    @RequestMapping(value = "delete/{product_id}/{discount_id}", method = RequestMethod.DELETE)
    public ResponseEntity<String> deleteProductDiscount(@PathVariable("product_id") Long product_id, @PathVariable("discount_id") Long discount_id){
        try {
            productReposity.deleteProductDiscountByProductIdAndDiscountId(product_id, discount_id);
            return new ResponseEntity<String>("Xoá thành công!!", HttpStatus.OK);
        } catch (Exception e) {
            // TODO: handle exception
            return new ResponseEntity<String>("Xoá không thành công!!", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    // Edit
    @RequestMapping(value = "edit/{product_id}/{discount_id}", method = RequestMethod.GET)
    public ResponseEntity<List<Product_Discount_Model>> edit(@PathVariable("product_id") Long product_id, @PathVariable("discount_id") Long discount_id){
         return new ResponseEntity<>(productReposity.findByProductIdAndDiscountId(product_id,discount_id),HttpStatus.OK);
    }

    // Update
    @RequestMapping(value = "update", method = RequestMethod.PUT)
    public ResponseEntity<Product_Discount_Model> update(@RequestBody Product_Discount_Model model){
        return new ResponseEntity<Product_Discount_Model>( productService.addProductDiscount(model), HttpStatus.OK);
    }

}
