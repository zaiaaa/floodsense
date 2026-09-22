package com.upx.floodsense;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.web.client.RestTemplate;

@EnableAsync
@SpringBootApplication
public class FloodsenseApplication {

	public static void main(String[] args) {
		SpringApplication.run(FloodsenseApplication.class, args);
	}

	public RestTemplate restTemplate(){ return new RestTemplate(); }
}
