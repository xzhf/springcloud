package com.xx.springcloud.sleuth;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import zipkin.server.EnableZipkinServer;

@EnableZipkinServer
@EnableEurekaClient
@SpringBootApplication
public class XxSpringcloudSleuthApplication {

	public static void main(String[] args) {
		SpringApplication.run(XxSpringcloudSleuthApplication.class, args);
	}
}
