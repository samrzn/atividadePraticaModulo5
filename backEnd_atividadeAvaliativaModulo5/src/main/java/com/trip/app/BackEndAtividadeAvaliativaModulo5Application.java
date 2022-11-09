package com.trip.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EntityScan(basePackages = { "com.trip.model.entity" })
@EnableJpaRepositories(basePackages = { "com.trip.repositories" })
@ComponentScan(basePackages = { "com.trip.controller", "com.trip.services", "com.trip.services.impl" })
@SpringBootApplication
public class BackEndAtividadeAvaliativaModulo5Application {

	public static void main(String[] args) {
		SpringApplication.run(BackEndAtividadeAvaliativaModulo5Application.class, args);
	}

}
