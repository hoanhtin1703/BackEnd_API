package com.example.demo.controller;

import com.example.demo.model.Oder_Model;
import com.example.demo.model.Product_Model;
import com.example.demo.repo.OderReposity;
import com.example.demo.service.Product_ServiceIml;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("order/")
public class Oder_Controller {
    @Autowired
    private Product_ServiceIml productServiceIml;
//    @Autowired
//    private OderReposity oderReposity;

    // display data
    @GetMapping("data")
    List<Oder_Model> getAllOder(){
        return productServiceIml.getAllOder();
    }
    // add Oder
    @PostMapping("save")
    Oder_Model addOder(@RequestBody Oder_Model oderModel){
         return (Oder_Model) productServiceIml.addOder(oderModel);
    }
    //delete Oder
    @DeleteMapping("delete/{id}")
    public ResponseEntity<Oder_Model> deleteOder(@PathVariable("id") long id){
        try {

            productServiceIml.deleteOder(id);
            return new ResponseEntity<Oder_Model>(HttpStatus.OK);
        }
        catch (Exception e) {
            // TODO: handle exception
            return new ResponseEntity<Oder_Model>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    //update Oder
    @PutMapping("update")
    public ResponseEntity<Oder_Model> updateOder( @RequestBody Oder_Model oderModel) {
        return new ResponseEntity<Oder_Model>( productServiceIml.addOder(oderModel), HttpStatus.OK);
    }

}
