package com.example.demo.service;

import com.example.demo.controller.Product_Color_Detail_Controller;
import com.example.demo.model.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStream;
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
    void addProductColor(Product_Color_Model product_color_model);
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
    //  Country Service
    List<Country_Model> getAllCountry();
    Country_Model saveCountry(Country_Model country);
    void deleteCountry(Long id);
    Optional<Country_Model> findCountryById(Long id);
    // City Service
    List<City_Model> getAllCity();
    City_Model saveCity(City_Model city);
    void deleteCity(Long id);
    Optional<City_Model> findCityById(Long id);
    // District Service
    List<District_Model> getAllDistrict();
    District_Model saveDistrict(District_Model district);
    void deleteDistrict(Long id);
    Optional<District_Model> findDistrictById(Long id);
    // Product Discount Service
    List<Product_Discount_Model> getAllProductDiscount();
    Product_Discount_Model addProductDiscount(Product_Discount_Model product_discount_model);
    void deleteProductDiscount(Long product_id);
    // product_color_detail
    List<Product_Image_Detail_Model> getAllProductColorDetail();
    //save
    Product_Image_Detail_Model addProductColorDetail(Product_Image_Detail_Model product_image_detail_model);
// Upload image Service
    String UploadFile(String path, MultipartFile file) ; // Hàm upload cũ
public void init(); // Hàm khởi tạo
    public void UploadFile( MultipartFile file) ; // Hàm mới
    InputStream GetImage(String path, String filename) throws IOException;
    // Service size
    List<Product_Size_Model> getAllProductSizeModel();
    Product_Size_Model addProductSizeModel(Product_Size_Model productSizeModel);
    Product_Size_Model saveProductSize(Product_Size_Model productSizeModel);

    //Oder service by Quan

    List<Oder_Model> getAllOder();
    Oder_Model addOder(Oder_Model oderModel);
    void deleteOder(Long id);
    Optional<Oder_Model> findOderById(Long id);
    // Order Detail Service
    List<Oder_Detail_Model> getAllOrderDetail();
    Oder_Detail_Model saveOrderDetail(Oder_Detail_Model order_detail);
    void deleteOrderDetail(Long id);
    Optional<Oder_Detail_Model> findOrderDetailById(Long id);



}
