package com.api.upgrad.bootrestbooks;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class BootrestbooksApplication {

	public static void main(String[] args) {

		ApplicationContext context =  SpringApplication.run(BootrestbooksApplication.class, args);
	}

}
