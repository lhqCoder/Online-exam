package com.ojlhq.oj;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class OjApplication {

	public static void main(String[] args) {
		SpringApplication.run(OjApplication.class, args);
		System.out.println("hello word");
	}

}
