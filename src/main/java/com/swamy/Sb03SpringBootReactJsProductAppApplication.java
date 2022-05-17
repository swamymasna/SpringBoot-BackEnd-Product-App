package com.swamy;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;

@OpenAPIDefinition
@SpringBootApplication
public class Sb03SpringBootReactJsProductAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(Sb03SpringBootReactJsProductAppApplication.class, args);
	}

	/*
	 * //@Bean public WebMvcConfigurer corsConfigurer() { return new
	 * WebMvcConfigurer() {
	 * 
	 * @Override public void addCorsMappings(CorsRegistry registry) {
	 * registry.addMapping("/**") .allowedOrigins("*") .allowedMethods("GET", "PUT",
	 * "POST", "PATCH", "DELETE", "OPTIONS"); } }; }
	 */
	
}
