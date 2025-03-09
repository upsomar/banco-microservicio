package com.banco.micro.cuenta;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cloud.openfeign.EnableFeignClients;


@EnableFeignClients
@SpringBootApplication
@EntityScan("com.banco.micro.commons.*")
public class BancoMicroCuentaApplication {

	public static void main(String[] args) {
		SpringApplication.run(BancoMicroCuentaApplication.class, args);
	}

}
