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

	@RequestMapping("/callauctions")
	public String callHome() {
		String response = restTemplate.getForObject("http://localhost:8081/auctions", String.class);
		return "Zipkin [" + response + "]";
	}

	@RequestMapping(value = "/auctions", method = RequestMethod.GET)
	public String getAuctions() throws InterruptedException {
		Thread.sleep(1000);
		return "Welcome to Layer2 " + callLayer3();
	}

	public String callLayer3() {
		return "Welcome to layer3 " + callLayer4();
	}

	public String callLayer4() {
		return "Hi I am layer 4";
	}

}
