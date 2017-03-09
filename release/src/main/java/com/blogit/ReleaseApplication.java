package com.blogit;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@EnableAutoConfiguration
@ComponentScan(basePackages = {
		"com.blogit.controllers"
})
public class ReleaseApplication {

	public static void main(String[] args) {
		SpringApplication.run(ReleaseApplication.class, args);
	}
}
