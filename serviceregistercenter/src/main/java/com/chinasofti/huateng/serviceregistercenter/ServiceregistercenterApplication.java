package com.chinasofti.huateng.serviceregistercenter;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@EnableEurekaServer
@SpringBootApplication
public class ServiceregistercenterApplication {

	public static void main(String[] args) {
		SpringApplication.run(ServiceregistercenterApplication.class, args);
	}
}
