package com.scrapping.mercadoLibre;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class MercadoLibreApplication {

	public static void main(String[] args) {
		SpringApplication.run(MercadoLibreApplication.class, args);
	}

}
