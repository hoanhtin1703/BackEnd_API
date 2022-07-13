package com.example.demo.service;

import com.example.demo.model.*;

import java.util.List;
import java.util.Optional;

public interface Product_Service {
    //Product_Service Model
    List<Product_Model> getAllProduct();

    public Product_Model saveProduct(Product_Model product);

    void deleteProduct(Long id);

    Optional<Product_Model> findProductById(Long id);
    // Brand Model Service
    List<Brand_Model> getAllBrand();
    public Brand_Model saveBrand(Brand_Model brand);
    void deleteBrand(Long id);
    Optional<Brand_Model> findBrandById(Long id);

    // User Model Service
    List<User_Model> getAllUser();
    User_Model saveUser(User_Model user);
    void deleteUser(Long id);
    Optional<User_Model> findUserById(Long id);
    // Oder Service
    //Oder_Detail_Service
   // Contact Service
    List<Contact_Model> getContact();
    Contact_Model saveContact(Contact_Model contact);
    void deleteContact(Long id);
    Optional<Contact_Model> findContactById(Long id);

    // Product Color Service
    List<Product_Color_Model> getAllProductColor();

    Product_Color_Model addProductColor(Product_Color_Model product_color_model);

    void deleteProductColor(Long product_id);


    // Voucher Model Service
    List<Voucher_Model> getAllVoucher();
    Voucher_Model saveVoucher(Voucher_Model voucher);
    void deleteVoucher(Long id);
    Optional<Voucher_Model> findVoucherById(Long id);


    //  Slider Service
    List<Slider_Model> getAllSlider();
    Slider_Model saveSlider(Slider_Model slider);
    void deleteSlider(Long id);
    Optional<Slider_Model> findSliderById(Long id);


    //  Comment Service
    List<Comment_Model> getAllComment();
    Comment_Model saveComment(Comment_Model comment);
    void deleteComment(Long id);
    Optional<Comment_Model> findCommentById(Long id);

}
