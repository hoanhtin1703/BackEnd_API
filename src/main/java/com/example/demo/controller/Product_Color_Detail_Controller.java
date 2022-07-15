package com.example.demo.controller;


import com.example.demo.model.Product_Image_Detail_Model;
import com.example.demo.repo.Product_Image_Detail_Repo;
import com.example.demo.service.Product_ServiceIml;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("product/colorDetail/")
public class Product_Color_Detail_Controller {
    @Autowired
    private Product_Image_Detail_Repo productImageDetailRepo;
    private Product_ServiceIml productServiceIml;

    // Xóa theo 2 key
    @DeleteMapping("delete")
    public ResponseEntity<Product_Image_Detail_Model> delete(@RequestParam(name = "image_color") String img_color,@RequestParam(name = "image_detail") String img_detail) {
        System.out.println(img_color+img_detail);
        productImageDetailRepo.deleteProductColorModelByproductidAndimagecolor(img_color,img_detail);
        return  new ResponseEntity<>(HttpStatus.OK);
    }
    // Tìm kiếm
    @GetMapping("search")
    public ResponseEntity<List<Product_Image_Detail_Model>> search(@RequestParam(name = "image_color") String image_color, @RequestParam(name = "image_detail") String image_detail){
        return  new ResponseEntity<>(productImageDetailRepo.searchProductColorDetailModelByproductidAndimagecolor(image_color,image_detail),HttpStatus.OK);
    }
// UPDATE
    @RequestMapping(value = "update", method = RequestMethod.POST)
    public ResponseEntity<Object>update(@RequestBody Map<Object,String> image_detail_update){
        System.out.println(image_detail_update.get("image_detail_update"));
        String img_color_update = image_detail_update.get("image_detail_update");
        String img_color = image_detail_update.get("image_color");
        String img_detail = image_detail_update.get("image_detail");

        try{
            productImageDetailRepo.updateProductColorDeltailModelByImagedetailAndimagecolor(img_color,img_color_update,img_detail);
            HashMap<String, Object> reuslt = new HashMap<>();
            reuslt.put("image_color", img_color);
            reuslt.put("image_detail", img_color_update);
            return ResponseEntity.status(HttpStatus.OK).body(reuslt);
        } catch (Exception ex){
            System.out.println(ex.getMessage());
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    /*
** Viết hàm thêm
     */
    //save
    @PostMapping("save")
    public Product_Image_Detail_Model addProductColor(@RequestBody Product_Image_Detail_Model productImageDetailModel) {

        return (Product_Image_Detail_Model) productServiceIml.addProductColorDetail(productImageDetailModel);
    }
}
