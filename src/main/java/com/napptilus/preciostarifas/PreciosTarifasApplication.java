package com.napptilus.preciostarifas;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories
public class PreciosTarifasApplication {

	public static void main(String[] args) {
		SpringApplication.run(PreciosTarifasApplication.class, args);
	}

}
