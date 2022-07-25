package com.example.demo.controller;

import com.example.demo.model.Product_Size_Model;
import com.example.demo.repo.Product_Size_Repository;
import com.example.demo.service.Product_ServiceIml;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("product/size/")
public class Product_Size_Controller {
    @Autowired
    Product_Size_Repository productSizeReponsitory;
    @Autowired
    Product_ServiceIml productSizeService;

    //Display
    @GetMapping("data")
    public List<Product_Size_Model> getAllProductSizeModel() {
        return productSizeService.getAllProductSizeModel();
        //Add

    }

    @PostMapping("save")
    public Product_Size_Model addProductSizeModel(@RequestBody Product_Size_Model productSizeModel) {
        return (Product_Size_Model) productSizeService.addProductSizeModel(productSizeModel);
    }

    //delete
    @DeleteMapping("delete")
    public ResponseEntity<Product_Size_Model> delete(@RequestParam(name = "image_color") String img_color, @RequestParam(name = "size_id") int size_id) {
        System.out.println(img_color + size_id);
        productSizeReponsitory.deleteProductSizeModelByImageColorAndSizeId(img_color, size_id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    //search
    @GetMapping("search")
    public ResponseEntity<List<Product_Size_Model>> search(@RequestParam(name = "image_color") String image_color, @RequestParam(name = "size_id") int size_id) {
        return new ResponseEntity<>(productSizeReponsitory.searchProductSizeModelByImageColorAndSizeId(image_color, size_id), HttpStatus.OK);
    }

    //update
    @PutMapping(name = "update")
    public ResponseEntity<Product_Size_Model> update(@RequestBody Product_Size_Model productSizeModel) {
        return new ResponseEntity<Product_Size_Model>(productSizeService.saveProductSize(productSizeModel), HttpStatus.OK);
    }

    //update so luong
    @RequestMapping(value = "updatequantity", method = RequestMethod.POST)
    public ResponseEntity<Object> update(@RequestBody Map<Object, String> quantity) {
        System.out.println(quantity.get("quantity"));
        int quantity1 = Integer.parseInt(quantity.get("quantity"));
        int id = Integer.parseInt(quantity.get("size_id"));
        String image = quantity.get("image_color");

        try {
            productSizeReponsitory.updateQuantity(image, quantity1, id);
            HashMap<String, Object> reuslt = new HashMap<>();
            reuslt.put("image_color", image);
            reuslt.put("size_id", id);
            reuslt.put("quantity", quantity1);
            return ResponseEntity.status(HttpStatus.OK).body(reuslt);
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
//
    // update sell
    @RequestMapping(value = "updatesell", method = RequestMethod.POST)
    public ResponseEntity<Object> updatesell(@RequestBody Map<Object, String> sell) {
        System.out.println(sell.get("sell"));
        int sell1 = Integer.parseInt(sell.get("sell"));
        int id = Integer.parseInt(sell.get("size_id"));
        String image = sell.get("image_color");

        try {
            productSizeReponsitory.updateSold(image, sell1, id);
            HashMap<String, Object> reuslt = new HashMap<>();
            reuslt.put("image_color", image);
            reuslt.put("size_id", id);
            reuslt.put("sell", sell1);
            return ResponseEntity.status(HttpStatus.OK).body(reuslt);
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
