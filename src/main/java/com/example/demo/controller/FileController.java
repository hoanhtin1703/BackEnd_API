package com.example.demo.controller;

import com.example.demo.model.FileRespone;
import com.example.demo.service.Product_Service;
import com.example.demo.service.Product_ServiceIml;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StreamUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
@RestController
@RequestMapping("File/")
public class FileController {
    @Autowired
    Product_Service fileStoreService;
    @Autowired
    private Product_ServiceIml fileSystemStorageService;
    @Value("${project.image}")
    String path;
    String message = "";
    // upload image cu
    @PostMapping("upload")
    public ResponseEntity<FileRespone> upload(@RequestParam("files") MultipartFile[] files) throws IOException {
//        String filename =null;
        try {
            List<String> fileNames = new ArrayList<>();
           Arrays.asList(files).stream().forEach(file -> {
             fileSystemStorageService.UploadFile(path, file);
               fileNames.add(file.getOriginalFilename());
           });
           message = "Uploaded the files successfully: " + fileNames;
           return ResponseEntity.status(HttpStatus.OK).body(new FileRespone(message));
        } catch (Exception e) {
            e.printStackTrace();
            message = "Fail to upload files!";
           return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(new FileRespone(message));
        }
    }
    // Upload file new
//    @PostMapping("upload")
//   public ResponseEntity<FileRespone> upload(@RequestParam("files") MultipartFile[] files) throws IOException{
//       try {
//           List<String> fileNames = new ArrayList<>();
//           Arrays.asList(files).stream().forEach(file -> {
//
//               fileSystemStorageService.UploadFile(file);
//               fileNames.add(file.getOriginalFilename());
//           });
//           message = "Uploaded the files successfully: " + fileNames;
//           return ResponseEntity.status(HttpStatus.OK).body(new FileRespone(message));
//       } catch (Exception e) {
//           message = "Fail to upload files!";
//           return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(new FileRespone(message));
//       }
//
//   }
    // display image
    @RequestMapping(value = "/{image_name}", method = RequestMethod.GET)
    void getImage(@PathVariable("image_name")String image_name , HttpServletResponse response) throws IOException {
        InputStream inputStream = this.fileSystemStorageService.GetImage(path,image_name);
        response.setContentType(MediaType.IMAGE_JPEG_VALUE);
        StreamUtils.copy(inputStream,response.getOutputStream());
    }
}
