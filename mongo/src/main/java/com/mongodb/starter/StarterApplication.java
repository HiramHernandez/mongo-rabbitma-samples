package com.mongodb.starter;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class StarterApplication {

	@GetMapping("/")
	public String hello() {
		return "Hello, World!";
	}

	public static void main(String[] args) {
		try{
			System.out.println("INiciando la APP...");
			SpringApplication.run(StarterApplication.class, args);
		}catch (Exception ex){
			System.out.println("Ha ocurrido un error!!!");
			System.out.println(ex.getMessage());
		}

	}

}
