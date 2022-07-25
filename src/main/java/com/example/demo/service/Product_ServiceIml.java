package com.example.demo.service;

import com.example.demo.model.*;
import com.example.demo.repo.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Optional;

@Service
public class Product_ServiceIml implements Product_Service {


    // Product Service Imp
    @Autowired
    private ProductReposity productReposity;
    @Override
    public List<Product_Model> getAllProduct() {
        return (List<Product_Model>) productReposity.findAll(Sort.by(Sort.Direction.DESC, "id"));
    }
    @Override
    public Product_Model saveProduct(Product_Model product) {
        return productReposity.save(product);
    }
    @Override
    public void deleteProduct(Long id) {
        productReposity.deleteById(id);
    }
    @Override
    public Optional<Product_Model> findProductById(Long id) {
        return productReposity.findById(id);
    }
    // Brand Service Imp
    @Autowired
    private BrandReposity brandReposity;
    @Override
    public List<Brand_Model> getAllBrand() {
        return brandReposity.findAll();
    }
    @Override
    public Brand_Model saveBrand(Brand_Model brand) {
        return brandReposity.save(brand);
    }
    @Override
    public void deleteBrand(Long id) {
        brandReposity.deleteById(id);
    }
    @Override
    public Optional<Brand_Model> findBrandById(Long id) {
        return brandReposity.findById(id);
    }
    // User Service Imp
    @Autowired
    private UserReposity userReposity;
    @Override
    public List<User_Model> getAllUser() {
        return userReposity.findAll();
    }
    @Override
    public User_Model saveUser(User_Model user) {
        return userReposity.save(user);
    }
    @Override
    public void deleteUser(Long id) {
        userReposity.deleteById(id);
    }
    @Override
    public Optional<User_Model> findUserById(Long id) {
        return userReposity.findById(id);
    }

    //Contact Service Imp
    @Autowired
    ContactReposity contactReposity;
    @Override
    public List<Contact_Model> getContact() {
        return contactReposity.findAll();
    }
    @Override
    public Contact_Model saveContact(Contact_Model contact) {
        return contactReposity.save(contact);
    }
    @Override
    public void deleteContact(Long id) {
        contactReposity.deleteById(id);
    }
    @Override
    public Optional<Contact_Model> findContactById(Long id) {
        return contactReposity.findById(id);
    }
    //product color service imp
    @Autowired
    private Product_Color_Reposity product_repository;
    @Override
    public List<Product_Color_Model> getAllProductColor() {
        return product_repository.findAll();
    }
    @Override
    public Product_Color_Model addProductColor(Product_Color_Model product_color_model) {
        return (Product_Color_Model) product_repository.save(product_color_model);
    }
    @Override
    public void deleteProductColor(Long product_id) {
        product_repository.deleteById(product_id);
    }
    //Voucher service imp
    @Autowired
    private VoucherReposity voucherRepository;
    @Override
    public List<Voucher_Model> getAllVoucher() {
        return voucherRepository.findAll();
    }
    @Override
    public Voucher_Model saveVoucher(Voucher_Model voucher) {
        return voucherRepository.save(voucher);
    }
    @Override
    public void deleteVoucher(Long id) {
        voucherRepository.deleteById(id);
    }
    @Override
    public Optional<Voucher_Model> findVoucherById(Long id) {
        return voucherRepository.findById(id);
    }
    //Voucher service imp
    @Autowired
    private SliderReposity sliderRepository;
    @Override
    public List<Slider_Model> getAllSlider() {
        return sliderRepository.findAll();
    }
    @Override
    public Slider_Model saveSlider(Slider_Model slider) {
        return sliderRepository.save(slider);
    }
    @Override
    public void deleteSlider(Long id) {
        sliderRepository.deleteById(id);
    }
    @Override
    public Optional<Slider_Model> findSliderById(Long id) {
        return sliderRepository.findById(id);
    }
    //Comment service imp
    @Autowired
    private CommentReposity commentRepository;
    @Override
    public List<Comment_Model> getAllComment() {
        return commentRepository.findAll();
    }
    @Override
    public Comment_Model saveComment(Comment_Model comment) {
        return commentRepository.save(comment);
    }
    @Override
    public void deleteComment(Long id) {
        commentRepository.deleteById(id);
    }
    @Override
    public Optional<Comment_Model> findCommentById(Long id) {
        return commentRepository.findById(id);
    }
    //Country service imp
    @Autowired
    private CountryReposity countryRepository;
    @Override
    public List<Country_Model> getAllCountry() {
        return countryRepository.findAll();
    }
    @Override
    public Country_Model saveCountry(Country_Model country) {
        return countryRepository.save(country);
    }
    @Override
    public void deleteCountry(Long id) {
        countryRepository.deleteById(id);
    }
    @Override
    public Optional<Country_Model> findCountryById(Long id) {
        return countryRepository.findById(id);
    }
    // City Service Imp
    @Autowired
    private CityReposity cityReposity;
    @Override
    public List<City_Model> getAllCity() {
        return cityReposity.findAll();
    }
    @Override
    public City_Model saveCity(City_Model city) {
        return cityReposity.save(city);
    }
    @Override
    public void deleteCity(Long id) {
        cityReposity.deleteById(id);
    }
    @Override
    public Optional<City_Model> findCityById(Long id) {
        return cityReposity.findById(id);
    }
    // District Service Imp
    @Autowired
    private DistrictReposity districtReposity;
    @Override
    public List<District_Model> getAllDistrict() {
        return districtReposity.findAll();
    }
    @Override
    public District_Model saveDistrict(District_Model district) {
        return districtReposity.save(district);
    }
    @Override
    public void deleteDistrict(Long id) {
        districtReposity.deleteById(id);
    }
    @Override
    public Optional<District_Model> findDistrictById(Long id) {
        return districtReposity.findById(id);
    }
// Product Discount Service Imp
    @Autowired
    Product_Discount_Reposity product_discount_reposity;
    @Override
    public List<Product_Discount_Model> getAllProductDiscount() {
        return product_discount_reposity.findAll();
    }
    @Override
    public Product_Discount_Model addProductDiscount(Product_Discount_Model product_discount_model) {
        return product_discount_reposity.save(product_discount_model);
    }
    @Override
    public void deleteProductDiscount(Long product_id) {
    }

    //Product_color_detail
    @Autowired
    private Product_Image_Detail_Repo productImageDetailRepo;
    @Override
    public Product_Image_Detail_Model addProductColorDetail(Product_Image_Detail_Model product_image_detail_model) {
        return  productImageDetailRepo.save(product_image_detail_model);

    }

    // Upload image service imp
    // upload ảnh cũ
    @Override
    public String UploadFile(String path, MultipartFile file)  {
//        // File name
        String name = file.getOriginalFilename();
//        // Create folder if not created
        File f = new File(path);
        if(!f.exists()){
            f.mkdir();
        }
        try {
            // Full path
            String filepath= path+ File.separator+name;
            // file copy
            Files.copy(file.getInputStream(), Paths.get(filepath));

        } catch (Exception e) {
            throw new RuntimeException("Could not store the file. Error: " + e.getMessage());
        }
        return name;
    }

    // hàm upload mới
    private final Path path = Paths.get("upload");

    @Override
    public void init() {
        try {
            Files.createDirectory(path);
        } catch (IOException e) {
            throw new RuntimeException("Could not initialize folder for upload!");
        }
    }
    @Override
    public void UploadFile(MultipartFile file) {
        try {
            Files.copy(file.getInputStream(), this.path.resolve(file.getOriginalFilename()));
        } catch (Exception e) {
            throw new RuntimeException("Could not store the file. Error: " + e.getMessage());
        }
    }
    // Hien thi anh
    @Override
    public InputStream GetImage(String path, String filename) throws IOException {
        String fullpath = path+File.separator+filename;
        InputStream inputStream = new FileInputStream(fullpath);
        return inputStream;
    }
    // Product_size Service//
    @Autowired
    private Product_Size_Repository productSizeReponsitory;
    @Override
    public List<Product_Size_Model> getAllProductSizeModel() {
        return (List<Product_Size_Model>) productSizeReponsitory.findAll();
    }

    @Override
    public Product_Size_Model addProductSizeModel(Product_Size_Model productSizeModel) {
        return (Product_Size_Model) productSizeReponsitory.save(productSizeModel);
    }

    @Override
    public Product_Size_Model saveProductSize(Product_Size_Model productSizeModel) {
        return productSizeReponsitory.save(productSizeModel);
    }

}
