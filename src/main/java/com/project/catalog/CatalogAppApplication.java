package com.project.catalog;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;

@OpenAPIDefinition(info = @Info(title = "Catalog API", version = "1.0", description = "Catalog API Information"))
@SpringBootApplication
public class CatalogAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(CatalogAppApplication.class, args);
	}

}
