package com.banco.micro.eureka;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;
@EnableEurekaServer
@SpringBootApplication
public class BancoMicroEurekaServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(BancoMicroEurekaServerApplication.class, args);
	}

}
