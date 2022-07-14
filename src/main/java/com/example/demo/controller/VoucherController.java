package com.example.demo.controller;

import com.example.demo.model.Voucher_Model;
import com.example.demo.repo.VoucherReposity;
import com.example.demo.service.Product_ServiceIml;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("voucher/")

public class VoucherController {
    @Autowired
    private VoucherReposity voucherReposity;
    @Autowired
    Product_ServiceIml voucher_service;
    // Hiển Thị
    @GetMapping("data")
    List<Voucher_Model> getAllVoucher(){
        return voucher_service.getAllVoucher();

    }
    // Thêm
    @PostMapping("save")
    public ResponseEntity<Voucher_Model> save(@RequestBody Voucher_Model voucher){
        return  new ResponseEntity<Voucher_Model>(voucher_service.saveVoucher(voucher), HttpStatus.OK);
    }
// Tìm kiếm
    @GetMapping("search/{keyword}")
    public ResponseEntity<List<Voucher_Model>> search(@PathVariable("keyword") String keyword){
        return new ResponseEntity<>(voucherReposity.findByCodeContaining(keyword), HttpStatus.OK);

    }
// Tìm kiếm theo id
    @GetMapping("edit/{id}")
    public ResponseEntity<Voucher_Model> edit(@PathVariable("id") Long id){
        Optional<Voucher_Model> item = voucher_service.findVoucherById(id);
        return ResponseEntity.of(item);
    }
    // Chỉnh sửa
    @PutMapping("update")
    public ResponseEntity<Voucher_Model> updateTutorial( @RequestBody Voucher_Model model) {
        return new ResponseEntity<Voucher_Model>( voucher_service.saveVoucher(model), HttpStatus.OK);
    }
    // Xóa
    @DeleteMapping("delete/{id}")
    public ResponseEntity<Voucher_Model> deleteVoucher(@PathVariable("id") long id){
        try {

            voucher_service.deleteVoucher(id);
            return new ResponseEntity<Voucher_Model>(HttpStatus.OK);
        }
        catch (Exception e) {
            // TODO: handle exception
            return new ResponseEntity<Voucher_Model>(HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }
}
