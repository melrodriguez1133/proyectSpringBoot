package com.infsis.proyectSpringBoot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
public class ProyectSpringBootApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProyectSpringBootApplication.class, args);
	}

}
