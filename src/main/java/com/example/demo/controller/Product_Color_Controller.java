package com.example.demo.controller;

import com.example.demo.model.Product_Color_Model;
import com.example.demo.repo.Product_Color_Reposity;
import com.example.demo.service.Product_ServiceIml;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("product/color/")
public class Product_Color_Controller {
    @Autowired
    private Product_ServiceIml productService;
    @Autowired
    private Product_Color_Reposity productColorReposity;

    // Hiển Thị
    @GetMapping("data")
    public List<Product_Color_Model> getAllProductColor() {
        return productService.getAllProductColor();
    }

    // Thêm
    @PostMapping("save")
    public Product_Color_Model addProductColor(@RequestBody Product_Color_Model product_color_model) {

        return (Product_Color_Model) productService.addProductColor(product_color_model);
    }

    // Xóa
    @DeleteMapping("delete")
    public ResponseEntity<Product_Color_Model> delete(@RequestParam(name = "product_id") Long id, @RequestParam(name = "image_color") String image_color) {
        System.out.println(id + image_color);
        productColorReposity.deleteProductColorModelByproductidAndimagecolor(id, image_color);
        return new ResponseEntity<>(HttpStatus.OK);
    }
    // Tìm Kiếm
    @GetMapping("search")
        public ResponseEntity<List<Product_Color_Model>> search(@RequestParam(name = "product_id") Long id, @RequestParam(name = "image_color") String image_color){

            return new ResponseEntity<>(productColorReposity.searchProductColorModelByproductidAndimagecolor(id, image_color), HttpStatus.OK);
        }
// Chỉnh sửa
@RequestMapping(value = "update", method = RequestMethod.POST)
public ResponseEntity<Object>update(@RequestBody Map<Object,String> image_color_update){
    System.out.println(image_color_update.get("image_color_update"));
    String img_color_update = image_color_update.get("image_color_update");
    Long id = Long.parseLong(image_color_update.get("product_id"));
    String img_color = image_color_update.get("image_color");
    try{
        productColorReposity.updateProductColorModelByproductidAndimagecolor(id,img_color_update,img_color);
        HashMap<String, Object> reuslt = new HashMap<>();
        reuslt.put("product_id", id);
        reuslt.put("image_color", img_color_update);
        return ResponseEntity.status(HttpStatus.OK).body(reuslt);
    } catch (Exception ex){
        System.out.println(ex.getMessage());
        return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
    }
