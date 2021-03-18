package com.aerztekasse;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("com.aerztekasse.*")
@EntityScan("com.aerztekasse.model")
@OpenAPIDefinition(info=@Info(title = "Places Rest API", description = "Api to display name, address and opening hours of business entities"))

public class PlacesRestApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(PlacesRestApiApplication.class, args);
	}

}
