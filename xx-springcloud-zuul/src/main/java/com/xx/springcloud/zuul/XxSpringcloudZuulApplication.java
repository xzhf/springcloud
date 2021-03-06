package com.xx.springcloud.zuul;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.cloud.sleuth.sampler.AlwaysSampler;
import org.springframework.context.annotation.Bean;

@EnableHystrixDashboard
@EnableZuulProxy
@EnableEurekaClient
@SpringBootApplication
public class XxSpringcloudZuulApplication {

	public static void main(String[] args) {
		SpringApplication.run(XxSpringcloudZuulApplication.class, args);
	}

    @Bean
    public AlwaysSampler defaultSampler() {
        return new AlwaysSampler();
    }
}
