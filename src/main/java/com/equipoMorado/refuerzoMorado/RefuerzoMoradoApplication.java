package com.equipoMorado.refuerzoMorado;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@SpringBootApplication
@EnableMongoRepositories
public class RefuerzoMoradoApplication {

	public static void main(String[] args) {
		SpringApplication.run(RefuerzoMoradoApplication.class, args);
	}

}
