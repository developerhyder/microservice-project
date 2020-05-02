package com.servicemarket.customer;

import java.util.Collections;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

import springfox.documentation.swagger2.annotations.EnableSwagger2;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

@SpringBootApplication
@EnableSwagger2
public class CustomerApplication {

	public static void main(String[] args) {
		SpringApplication.run(CustomerApplication.class, args);
	}
	@Bean
	RestTemplate getRestTemplate() {
		return new RestTemplate();
	}
	
	@Bean
	Docket configureSwagger(){
		return new Docket(DocumentationType.SWAGGER_2)
				.select()
				.paths(PathSelectors.ant("/customer/**"))
				.apis(RequestHandlerSelectors.basePackage("com.servicemarket.customer"))
				.build()
				.apiInfo(new ApiInfo("Customer's API",
						"Our Service market API",
						"1.0",
						"Ready to work for you",
						new Contact("Idris", "www.customersapi.com", "servicemarket@customerssapi.com"),
						"Standard API License",
						"www.servicemarketapi.com",
						Collections.emptyList()
						));
	}
}
