package com.banco.micro.config;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

@EnableConfigServer
@SpringBootApplication
public class BancoMicroConfigServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(BancoMicroConfigServerApplication.class, args);
	}

}
