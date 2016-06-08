package com.higedrum.springboot.rest.sample;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@EnableAutoConfiguration
@ComponentScan
public class App {

	@RequestMapping
	String home() {
		return "Hello world!";
	}

	public static void main(String[] args) {
		SpringApplication.run(App.class, args);
	}
}
