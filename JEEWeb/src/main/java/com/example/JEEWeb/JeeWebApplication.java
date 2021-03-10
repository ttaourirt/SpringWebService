package com.example.JEEWeb;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.HttpEntity;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@SpringBootApplication
public class JeeWebApplication {
	private static final Logger log = LoggerFactory.getLogger(JeeWebApplication.class);

	public static void main(String[] args) {

		SpringApplication.run(JeeWebApplication.class, args);

		RestTemplate restTemplate = new RestTemplate();

		HttpEntity<Car> request = new HttpEntity<>(new Car("55DD77", "Mazerati", 2000));
		restTemplate.postForObject("http://localhost:8080/cars", request, Car.class);

		List cars = restTemplate.getForObject("http://localhost:8080/cars", List.class);
		log.info(cars.toString());



	}

}
