package com.example.service;


import java.net.URI;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class ParentService {

	private final RestTemplate restTemplate;

	public ParentService(RestTemplate rest) {
		this.restTemplate = rest;
	}

	@HystrixCommand(fallbackMethod = "fallbackService1")
	public String getService1() {
		URI uri = URI.create("http://localhost:5001/service1");
		return "Hello from Parent Service [" + this.restTemplate.getForObject(uri, String.class)
				+ "]";
	}

	public String fallbackService1() {
		log.info("========Circuit Breaker==========");
		return "Falling back for service 1";
	}

}