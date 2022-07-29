package com.example.demo.controller;

import com.example.demo.model.Oder_Detail_Model;
import com.example.demo.model.Oder_Detail_Model;
import com.example.demo.repo.Oder_Detail_Reposity;
import com.example.demo.service.Product_ServiceIml;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("order_detail/")
public class Oder_Detail_Controller {
    @Autowired
    private Oder_Detail_Reposity orderDetailReposity;
    @Autowired
    Product_ServiceIml order_detail_service;
    // Hiển thị
    @GetMapping("data")
    List<Oder_Detail_Model> getAllOrderDetail(){
        return order_detail_service.getAllOrderDetail();

    }
    // thêm
    @PostMapping("save")
    public ResponseEntity<Oder_Detail_Model> save(@RequestBody Oder_Detail_Model OrderDetail){
        return  new ResponseEntity<Oder_Detail_Model>(order_detail_service.saveOrderDetail(OrderDetail), HttpStatus.OK);
    }
    // Tìm kiếm
    @GetMapping("search/{keyword}")
    public ResponseEntity<List<Oder_Detail_Model>> search(@PathVariable("keyword") String keyword){
        return new ResponseEntity<>(orderDetailReposity.findByProductNameContaining(keyword), HttpStatus.OK);

    }
    // Tìm kiếm theo id
    @GetMapping("edit/{id}")
    public ResponseEntity<Oder_Detail_Model> edit(@PathVariable("id") Long id){
        Optional<Oder_Detail_Model> item = order_detail_service.findOrderDetailById(id);
        return ResponseEntity.of(item);
    }
    // Chỉnh sửa
    @PutMapping("update")
    public ResponseEntity<Oder_Detail_Model> updateTutorial( @RequestBody Oder_Detail_Model model) {
        return new ResponseEntity<Oder_Detail_Model>( order_detail_service.saveOrderDetail(model), HttpStatus.OK);
    }
    // Xóa
    @DeleteMapping("delete/{id}")
    public ResponseEntity<String> deleteOrderDetail(@PathVariable("id") long id){
        try {

            order_detail_service.deleteOrderDetail(id);
            return new ResponseEntity<String>("Xoá thành công!!", HttpStatus.OK);
        }
        catch (Exception e) {
            // TODO: handle exception
            return new ResponseEntity<String>("Xoá không thành công!!", HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }
}
