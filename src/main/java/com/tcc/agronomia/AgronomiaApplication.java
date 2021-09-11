package com.tcc.agronomia;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
public class AgronomiaApplication {

	public static void main(String[] args) {
		SpringApplication.run(AgronomiaApplication.class, args);
	}

}
