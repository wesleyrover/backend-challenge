package com.invillia.acme.auth;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;

import java.util.TimeZone;

@SpringBootApplication
@EnableAutoConfiguration
@ComponentScan(value="com.invillia.acme.order")
public class OrderApplication  extends SpringBootServletInitializer {

	static {
		TimeZone.setDefault(TimeZone.getTimeZone("UTC"));
	}

	public static void main(String[] args) {
		SpringApplication.run(OrderApplication.class, args);
	}
}
