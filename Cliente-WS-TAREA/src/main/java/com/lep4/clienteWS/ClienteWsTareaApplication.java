package com.lep4.clienteWS;

import java.util.ArrayList;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;



@SpringBootApplication
public class ClienteWsTareaApplication {

	final static String url = "http://gturnquist-quoters.cfapps.io/api/random";

	
	public static void main(String[] args) {
		SpringApplication.run(ClienteWsTareaApplication.class, args);
	}
	
	@Bean
	public RestTemplate restTemplate(RestTemplateBuilder builder) {
		return builder.build();
	}
	
	@Bean
	public CommandLineRunner run (RestTemplate restTemplate) {
		return args -> {
			JsonRoot respuesta = restTemplate.getForObject(url, JsonRoot.class);
			System.out.println("Respuesta del Web Service");
			System.out.println(respuesta);
		};
		
	}
	
	
}
