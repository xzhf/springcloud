package com.xx.springcloud.config.server;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.cloud.config.server.EnableConfigServer;

@EnableConfigServer
@SpringBootApplication
public class SpringcloudConfigServerApplication extends SpringBootServletInitializer {

	public static void main(String[] args) {
//        System.setProperty("javax.net.debug", "all");
		SpringApplication.run(SpringcloudConfigServerApplication.class, args);
	}

	protected SpringApplicationBuilder configure (SpringApplicationBuilder builder) {
	    return builder.web(true).sources(SpringcloudConfigServerApplication.class);
    }
}
