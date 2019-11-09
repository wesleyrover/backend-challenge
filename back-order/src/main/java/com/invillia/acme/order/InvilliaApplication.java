package com.invillia.acme.order;

import com.invillia.acme.order.db.AcmeConfiguration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;

import java.util.TimeZone;

@SpringBootApplication
@EnableAutoConfiguration
@ComponentScan(value="com.invillia.acme.order")
public class InvilliaApplication  extends SpringBootServletInitializer {

	static {
		TimeZone.setDefault(TimeZone.getTimeZone("UTC"));
	}

	public static void main(String[] args) {
		SpringApplication.run(InvilliaApplication.class, args);
	}
}
