package com.stubs.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class StubsApplication {

	public static void main(String[] args) {
		SpringApplication.run(StubsApplication.class, args);
		System.out.println("Stub service started successfully");
	}

}
