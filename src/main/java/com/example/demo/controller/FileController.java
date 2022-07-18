package com.example.demo.controller;

import com.example.demo.model.FileRespone;
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

@RestController
@RequestMapping("File/")
public class FileController {
    @Autowired
    private Product_ServiceIml fileSystemStorageService;
    @Value("${project.image}")
    String path;
// upload image
    @PostMapping("upload")
    public ResponseEntity<FileRespone> upload(@RequestParam("file")MultipartFile file) throws IOException {
        String filename =null;
        try {
       filename = fileSystemStorageService.UploadFile(path, file);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(new FileRespone(null, "Submit successfully"), HttpStatus.OK);
        }
        return  new ResponseEntity<>(new FileRespone(filename,"Submit successfully"), HttpStatus.OK);
    }
    // display image
    @RequestMapping(value = "/{image_name}", method = RequestMethod.GET)
    void getImage(@PathVariable("image_name")String image_name , HttpServletResponse response) throws IOException {
        InputStream inputStream = this.fileSystemStorageService.GetImage(path,image_name);
        response.setContentType(MediaType.IMAGE_JPEG_VALUE);
        StreamUtils.copy(inputStream,response.getOutputStream());
    }
}
