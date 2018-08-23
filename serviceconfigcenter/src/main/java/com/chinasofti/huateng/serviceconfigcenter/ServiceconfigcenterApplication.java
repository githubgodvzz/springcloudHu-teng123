package com.chinasofti.huateng.serviceconfigcenter;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.config.server.EnableConfigServer;

@SpringBootApplication
@EnableConfigServer
@EnableDiscoveryClient
public class ServiceconfigcenterApplication {

	public static void main(String[] args) {
		SpringApplication.run(ServiceconfigcenterApplication.class, args);
	
		
	
	}
}
