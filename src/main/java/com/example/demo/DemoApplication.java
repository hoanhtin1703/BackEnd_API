package com.example.demo;


import com.example.demo.model.Product_Model;
import com.example.demo.service.Product_ServiceIml;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;

@SpringBootApplication
public class DemoApplication  implements CommandLineRunner {
	List<Product_Model> list;
//	Logger logger = LoggerFactory.getLogger(DemoApplication.class);
 	@Autowired
Product_ServiceIml filesystemService;
	public static void main(String[] args) {

		SpringApplication.run(DemoApplication.class, args);

	}
	@Override
	public void run(String... args) throws Exception {
//		filesystemService.init();
	}
}
