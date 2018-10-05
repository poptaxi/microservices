package com.example.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.example.service.ParentService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@EnableCircuitBreaker
@Api(tags = "Example")
@RestController
@Configuration
@EnableHystrixDashboard
public class ParentServiceController {

	@Autowired
	private RestTemplate restTemplate;

	@Autowired
	private ParentService parentService;

	@Bean
	public RestTemplate getRestTemplate() {
		return new RestTemplate();
	}

	@RequestMapping(value = "/callService1", method = RequestMethod.GET)
	@ApiOperation(value = "Get service1 data")
	public String callService1() {
		// String response =
		// restTemplate.getForObject("http://localhost:5001/service1", String.class);
		// return "Hello from Parent Service [" + response + "]";
		return parentService.getService1();
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

}
