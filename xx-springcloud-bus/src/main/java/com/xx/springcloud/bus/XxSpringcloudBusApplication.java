package com.xx.springcloud.bus;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@SpringBootApplication
public class XxSpringcloudBusApplication {

	public static void main(String[] args) {
		SpringApplication.run(XxSpringcloudBusApplication.class, args);
	}
}
