package com.example.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api(tags = "Example")
@RestController
public class ExampleController {

	@Autowired
	private RestTemplate restTemplate;

	@Bean
	public RestTemplate getRestTemplate() {
		return new RestTemplate();
	}

	@RequestMapping(value = "/callService1", method = RequestMethod.GET)
	@ApiOperation(value = "Get service1 data")
	public String callService1() {
		String response = restTemplate.getForObject("http://localhost:8081/service1", String.class);
		return "Hello from Parent Service [" + response + "]";
	}

	@RequestMapping(value = "/callService2", method = RequestMethod.GET)
	@ApiOperation(value = "Get service2 data")
	public String callService2() {
		String response = restTemplate.getForObject("http://localhost:8082/service2", String.class);
		return "Hello from Parent Service [" + response + "]";
	}

	@RequestMapping(value = "/callService3", method = RequestMethod.GET)
	@ApiOperation(value = "Get service3 data")
	public String callService3() {
		String response = restTemplate.getForObject("http://localhost:8083/service3", String.class);
		return "Hello from Parent Service [" + response + "]";
	}

	@RequestMapping(value = "/callService4", method = RequestMethod.GET)
	@ApiOperation(value = "Get service4 data")
	public String callService4() {
		String response = restTemplate.getForObject("http://localhost:8084/service4", String.class);
		return "Hello from Parent Service [" + response + "]";
	}

	@RequestMapping(value = "/callService5", method = RequestMethod.GET)
	@ApiOperation(value = "Get service5 data")
	public String callService5() {
		String response = restTemplate.getForObject("http://localhost:8085/service5", String.class);
		return "Hello from Parent Service [" + response + "]";
	}

	@RequestMapping(value = "/callService6", method = RequestMethod.GET)
	@ApiOperation(value = "Get service6 data")
	public String callService6() {
		String response = restTemplate.getForObject("http://localhost:8086/service6", String.class);
		return "Hello from Parent Service [" + response + "]";
	}

}
