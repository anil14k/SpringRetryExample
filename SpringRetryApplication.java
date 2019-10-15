package com.example.springretry;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.retry.annotation.EnableRetry;

@EnableRetry
@SpringBootApplication
@ComponentScan(basePackages= {"com.example.springretry"})
public class SpringRetryApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringRetryApplication.class, args);
	}
}
