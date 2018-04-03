package com.example.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class Service2Controller {

	@Autowired
	private RestTemplate restTemplate;

	@Bean
	public RestTemplate getRestTemplate() {
		return new RestTemplate();
	}

	@RequestMapping(value = "/service2", method = RequestMethod.GET)
	public String callService2() {
		String responseFrom4 = restTemplate.getForObject("http://localhost:8084/service4",
				String.class);
		String responseFrom5 = restTemplate.getForObject("http://localhost:8085/service5",
				String.class);
		return "Hello from Service2 [" + responseFrom4 + "]" + "[" + responseFrom5 + "]";
	}

}
