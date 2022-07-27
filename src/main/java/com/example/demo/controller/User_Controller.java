package com.example.demo.controller;

import com.example.demo.model.User_Model;
import com.example.demo.repo.UserReposity;
import com.example.demo.service.Mail_Service;
import com.example.demo.service.Product_ServiceIml;
import net.bytebuddy.utility.RandomString;
import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.web.bind.annotation.*;

import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Transport;
//import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMessage;
import javax.servlet.http.HttpServletRequest;
import java.util.*;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("user/")

public class User_Controller {

    @Autowired
    private UserReposity userReposity;
    @Autowired
    Product_ServiceIml user_service;

    @Autowired
    Mail_Service mail_service;

    // Hiển Thị
    @GetMapping("data")
    List<User_Model> getAllUser(){
        return user_service.getAllUser();

    }
    // Thêm
    @PostMapping("save")
    public ResponseEntity<User_Model> save(@RequestBody User_Model user){
        return  new ResponseEntity<User_Model>(user_service.saveUser(user), HttpStatus.OK);
    }
// Tìm Kiếm
    @GetMapping("search/{keyword}")
    public ResponseEntity<List<User_Model>> search(@PathVariable("keyword") String keyword){
        return new ResponseEntity<>(userReposity.findByNameContaining(keyword), HttpStatus.OK);

    }
// Tìm kiếm theo id
    @GetMapping("edit/{id}")
    public ResponseEntity<User_Model> edit(@PathVariable("id") Long id){
        Optional<User_Model> item = user_service.findUserById(id);
        return ResponseEntity.of(item);
    }
    // Chỉnh sửa
    @PutMapping("update")
    public ResponseEntity<User_Model> updateTutorial(@RequestBody User_Model model) {
        return new ResponseEntity<User_Model>( user_service.saveUser(model), HttpStatus.OK);
    }
    // Xóa
    @DeleteMapping("delete/{id}")
    public ResponseEntity<User_Model> deleteUser(@PathVariable("id") long id){
        try {

            user_service.deleteUser(id);
            return new ResponseEntity<User_Model>(HttpStatus.OK);
        }
        catch (Exception e) {
            // TODO: handle exception
            return new ResponseEntity<User_Model>(HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }
//// Mã hóa Md5 Password
//private static byte[] digest(byte[] input) {
//    MessageDigest md;
//    try {
//        md = MessageDigest.getInstance("MD5");
//    } catch (NoSuchAlgorithmException e) {
//        throw new IllegalArgumentException(e);
//    }
//    byte[] result = md.digest(input);
//    return result;
//}
//
//    private static String bytesToHex(byte[] bytes) {
//        StringBuilder sb = new StringBuilder();
//        for (byte b : bytes) {
//            sb.append(String.format("%02x", b));
//        }
//        return sb.toString();
//    }
    // Đăng nhập
    @PostMapping("login")
    public ResponseEntity<Object> login(@RequestBody Map<Object,String> user) throws Exception {
        String email = user.get("email");
        String password = user.get("password");
//        System.out.println(email+password);
        try {
            HashMap<String,Object> result = new HashMap<>();
            result.put("data",userReposity.show(email,password));

            if (!result.get("data").toString().equals("[]") ) {
                result.put("status", 1);
                return ResponseEntity.status(HttpStatus.OK).body(result);
            }
            else {
                result.put("status", 0);
                return ResponseEntity.status(HttpStatus.OK).body(result);
            }
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    //
//    @PostMapping("demo")
//    public String test(@RequestBody String password){
//        String pText = "Hello MD5";
//        System.out.println(String.format(OUTPUT_FORMAT, "Input (string)", pText));
//        byte[] md5InBytes = User_Controller.digest(pText.getBytes(UTF_8));
//        System.out.println(String.format(OUTPUT_FORMAT, "MD5 (hex) ", bytesToHex(md5InBytes)));
//        return String.format(OUTPUT_FORMAT, "MD5 (hex) ", bytesToHex(md5InBytes));
//    }
// Singup
    @PostMapping("signup")
    public ResponseEntity<Object> signup(@RequestBody User_Model user)  {

      String email =  user.getEmail();
//        System.out.println(email);
        try {
            Boolean result = userReposity.existsByEmail(user.getEmail());
                HashMap<String,Object> body = new HashMap<>();
            System.out.println(userReposity.existsByEmail(email));
            if (result) {
                body.put("data",null);
                body.put("status",0);
                //        User_Model userModel = new User_Model();
                return ResponseEntity.status(HttpStatus.OK).body(body);
            }
            else {

                user.setPassword(DigestUtils.md5Hex(user.getPassword()));
                User_Model userModel = user_service.saveUser(user);
                body.put("data",userModel);
                body.put("status",1);
                return ResponseEntity.status(HttpStatus.OK).body(body);
            }
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }



//    @GetMapping("/forgot_password")
//    public String showForgotPasswordForm() {
//        return null;
//    }

    @PostMapping("/forgot_password")
    public ResponseEntity<Object> processForgotPassword(HttpServletRequest request) throws Exception {
        String email = request.getParameter("email");
        System.out.println(request.getLocalAddr());
        System.out.println(request.getLocalName());
        System.out.println(email);
        try {
            User_Model user = userReposity.findByEmail(email);
            HashMap<String,Object> body = new HashMap<>();
            HashMap<String,Object> data = new HashMap<>();
            data.put("email", email);
            if (user != null) {
                String token = RandomString.make(30);
                user_service.updateResetPasswordToken(user, token);
                String resetPasswordLink = user_service.getSiteURL(request) + "/user/reset_password?email=" + email + "&token=" + token;
                mail_service.sendEmail(email, resetPasswordLink);
                data.put("token", token);
                body.put("data", data);
                body.put("status", 1);
            } else {
                body.put("data", data);
                body.put("status", 0);
            }
            return ResponseEntity.status(HttpStatus.OK).body(body);

        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }



    }


    @GetMapping("/reset_password")
    public String showResetPasswordForm(@Param(value = "token") String email, @Param(value = "token") String token) {
//        System.out.println("Reset Password");
//        System.out.println(email);
//        System.out.println(token);
        return null;

    }

    @PostMapping("/reset_password")
    public ResponseEntity<Object> processResetPassword(HttpServletRequest request) {
        String email = request.getParameter("email");
        String token = request.getParameter("token");
        String password = request.getParameter("password");

//        System.out.println(email);
//        System.out.println(token);
//        System.out.println(password);

        User_Model user = user_service.getByEmailAndResetPasswordToken(email, token);
        HashMap<String,Object> body = new HashMap<>();
        HashMap<String,Object> data = new HashMap<>();
        try {
            if (user == null) {

                data.put("token", token);

                body.put("data", data);
                body.put("status", 0);
            } else {

                user_service.updatePassword(user, password);

                data.put("email", email);
                data.put("password", user.getPassword());
                body.put("data", data);

                body.put("status", 1);

            }
            return ResponseEntity.status(HttpStatus.OK).body(body);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }



    }



}
