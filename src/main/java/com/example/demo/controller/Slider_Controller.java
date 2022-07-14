package com.example.demo.controller;

import com.example.demo.model.Slider_Model;
import com.example.demo.repo.SliderReposity;
import com.example.demo.service.Product_ServiceIml;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("slider/")

public class Slider_Controller {
    @Autowired
    private SliderReposity sliderReposity;
    @Autowired
    Product_ServiceIml slider_service;
    // Hiển thị
    @GetMapping("data")
    List<Slider_Model> getAllSlider(){
        return slider_service.getAllSlider();

    }
    // Thêm
    @PostMapping("save")
    public ResponseEntity<Slider_Model> save(@RequestBody Slider_Model slider){
        return  new ResponseEntity<Slider_Model>(slider_service.saveSlider(slider), HttpStatus.OK);
    }
// Tìm kiếm
    @GetMapping("search/{keyword}")
    public ResponseEntity<List<Slider_Model>> search(@PathVariable("keyword") String keyword){
        return new ResponseEntity<>(sliderReposity.findByTextContaining(keyword), HttpStatus.OK);

    }
// Tìm kiếm theo id
    @GetMapping("edit/{id}")
    public ResponseEntity<Slider_Model> edit(@PathVariable("id") Long id){
        Optional<Slider_Model> item = slider_service.findSliderById(id);
        return ResponseEntity.of(item);
    }
    // Chỉnh sửa
    @PutMapping("update")
    public ResponseEntity<Slider_Model> updateTutorial( @RequestBody Slider_Model model) {
        return new ResponseEntity<Slider_Model>( slider_service.saveSlider(model), HttpStatus.OK);
    }
    // Xóa
    @DeleteMapping("delete/{id}")
    public ResponseEntity<Slider_Model> deleteSlider(@PathVariable("id") long id){
        try {

            slider_service.deleteSlider(id);
            return new ResponseEntity<Slider_Model>(HttpStatus.OK);
        }
        catch (Exception e) {
            // TODO: handle exception
            return new ResponseEntity<Slider_Model>(HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }
}
