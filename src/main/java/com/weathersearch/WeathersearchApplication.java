package com.weathersearch;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class WeathersearchApplication {

	public static void main(String[] args) {
		SpringApplication.run(WeathersearchApplication.class, args);
	}

}
