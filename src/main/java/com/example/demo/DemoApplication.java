package com.example.demo;


import com.example.demo.model.Product_Model;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.CacheControl;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.List;
import java.util.concurrent.TimeUnit;

@SpringBootApplication

public class DemoApplication  implements WebMvcConfigurer {
	List<Product_Model> list;
//	Logger logger = LoggerFactory.getLogger(DemoApplication.class);
@Override
public void addResourceHandlers(ResourceHandlerRegistry registry) {

	// Register resource handler for images
	registry.addResourceHandler("/images/**").addResourceLocations("/WEB-INF/images/")
			.setCacheControl(CacheControl.maxAge(2, TimeUnit.HOURS).cachePublic());
}

	public static void main(String[] args) {

		SpringApplication.run(DemoApplication.class, args);
	}


}
