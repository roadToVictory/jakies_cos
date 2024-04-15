package com.example.WAFdemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
public class WafDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(WafDemoApplication.class, args);
	}


	@RestController
	public static class MyController {

		@GetMapping("/public")
		public String publicEndpoint() {
			return "Public endpoint accessed";
		}

		@GetMapping("/private")
		public String privateEndpoint() {
			return "Private endpoint accessed";
		}
	}

}
