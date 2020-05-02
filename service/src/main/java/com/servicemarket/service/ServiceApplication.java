package com.servicemarket.service;

import java.util.Collections;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableSwagger2
public class ServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(ServiceApplication.class, args);
	}
	
	@Bean
	Docket configureSwagger(){
		return new Docket(DocumentationType.SWAGGER_2)
				.select()
				.paths(PathSelectors.ant("/service/**"))
				.apis(RequestHandlerSelectors.basePackage("com.servicemarket.service"))
				.build()
				.apiInfo(new ApiInfo("Profile's API",
						"Our Service market API",
						"1.0",
						"We are ready to work for you",
						new Contact("ServiceMarket", "www.servicemarketapi.com", "servicemarket@Profilesapi.com"),
						"Standard API License",
						"www.Profilesapi.com",
						Collections.emptyList()
						));

	}
}
