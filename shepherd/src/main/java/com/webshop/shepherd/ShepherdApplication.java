package com.webshop.shepherd;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.webshop.shepherd.service.loader.HerdLoader;

@SpringBootApplication
public class ShepherdApplication {

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(ShepherdApplication.class, args);
		
		HerdLoader heardLoaderService = context.getBean(HerdLoader.class);
		
		System.out.println(heardLoaderService.getHerd().getYaks().size());
		
	}
}
