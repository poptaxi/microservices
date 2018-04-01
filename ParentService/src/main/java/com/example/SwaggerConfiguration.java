package com.example;


import java.util.Collections;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.ApiKey;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfiguration {

	@Bean
	public Docket api() {
		return new Docket(DocumentationType.SWAGGER_2).select()
				.apis(RequestHandlerSelectors.basePackage("com.example.controllers"))
				.paths(PathSelectors.any()).build().pathMapping("/").apiInfo(apiInfo())
				.useDefaultResponseMessages(false)
				.securitySchemes(Collections.singletonList(apiKey()));
	}

	private ApiInfo apiInfo() {
		return new ApiInfoBuilder().title("Microservices Examples using Spring cloud")
				.description("This application is craeted to learn spring cloud, microservices")
				.version("1.0").build();
	}

	private ApiKey apiKey() {
		return new ApiKey("token", "X-Auth-Token", "header");
	}

}
