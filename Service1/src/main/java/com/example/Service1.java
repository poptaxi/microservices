package com.example;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.sleuth.sampler.AlwaysSampler;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@EnableAutoConfiguration
@SpringBootApplication
@RestController
public class Service1 {

	@Autowired
	private RestTemplate restTemplate;

	public static void main(String[] args) {
		SpringApplication.run(Service1.class, args);
	}

	@Bean
	public AlwaysSampler defaultSampler() {
		return new AlwaysSampler();
	}

	@Bean
	public RestTemplate getRestTemplate() {
		return new RestTemplate();
	}

	@RequestMapping("/service1")
	public String callHome() {
		String response = restTemplate.getForObject("http://localhost:8081/home", String.class);
		return "Hello from service1 [" + response + "]";
	}

	@RequestMapping(value = "/home", method = RequestMethod.GET)
	public String getHome() throws InterruptedException {
		Thread.sleep(2000);
		return "===Welcome to service1===";
	}

}
