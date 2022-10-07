package com.gcep;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan("com.gcep")
@SpringBootApplication
public class SimpleTestApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(SimpleTestApiApplication.class, args);
	}

}
