package com.example;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.sleuth.sampler.AlwaysSampler;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@EnableAutoConfiguration
@SpringBootApplication
@RestController
public class ParentApplication {

	@Autowired
	private RestTemplate restTemplate;

	public static void main(String[] args) {
		SpringApplication.run(ParentApplication.class, args);
	}

	@Bean
	public AlwaysSampler defaultSampler() {
		return new AlwaysSampler();
	}

	@Bean
	public RestTemplate getRestTemplate() {
		return new RestTemplate();
	}

	@RequestMapping("/callService1")
	public String callService1() {
		String response = restTemplate.getForObject("http://localhost:8081/service1", String.class);
		return "Hello from Parent Service [" + response + "]";
	}

	@RequestMapping("/callService2")
	public String callService2() {
		String response = restTemplate.getForObject("http://localhost:8082/service2", String.class);
		return "Hello from Parent Service [" + response + "]";
	}

	@RequestMapping("/callService3")
	public String callService3() {
		String response = restTemplate.getForObject("http://localhost:8083/service3", String.class);
		return "Hello from Parent Service [" + response + "]";
	}

	@RequestMapping("/callService4")
	public String callService4() {
		String response = restTemplate.getForObject("http://localhost:8084/service4", String.class);
		return "Hello from Parent Service [" + response + "]";
	}

	@RequestMapping("/callService5")
	public String callService5() {
		String response = restTemplate.getForObject("http://localhost:8085/service5", String.class);
		return "Hello from Parent Service [" + response + "]";
	}

	@RequestMapping("/callService6")
	public String callService6() {
		String response = restTemplate.getForObject("http://localhost:8086/service6", String.class);
		return "Hello from Parent Service [" + response + "]";
	}

}
