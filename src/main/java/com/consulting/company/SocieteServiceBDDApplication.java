package com.consulting.company;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
public class SocieteServiceBDDApplication {

	public static void main(String[] args) {
		SpringApplication.run(SocieteServiceBDDApplication.class, args);
	}

}
