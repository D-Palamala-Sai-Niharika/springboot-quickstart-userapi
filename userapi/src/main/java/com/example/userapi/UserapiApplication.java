package com.example.userapi;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class UserapiApplication {

	public static void main(String[] args) {
		SpringApplication.run(UserapiApplication.class, args);
	}
	
	//SpringBootApplication contains @Configuration by default
	//@Configuration , @Bean - DI using  java annotation
	@Bean
	public ModelMapper modelMapper() { 
		return new ModelMapper();
	}

}
