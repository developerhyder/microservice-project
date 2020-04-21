package com.servicemarket.orchestrator;

import java.util.Collections;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableSwagger2
public class OrchestratorApplication {

	public static void main(String[] args) {
		SpringApplication.run(OrchestratorApplication.class, args);
	}
	
	
	@Bean
	RestTemplate getRestTemplate() {
		return new RestTemplate();
	}
	
	@Bean
	Docket configureSwagger(){
		return new Docket(DocumentationType.SWAGGER_2)
					.select()
					.paths(PathSelectors.ant("/**"))
				.apis(RequestHandlerSelectors.basePackage("com.servicemarket.orchestrator"))
				.build()
				.apiInfo(new ApiInfo("Service Market API",
						"Our Test API for learning",
						"1.0",
						"Learning should never end",
						new Contact("byte code", "www.howdidilearnjava.com", "java@oracle.com"),
						"Standard API License",
						"www.usersapi.com",
						Collections.emptyList()
						));	}

}
