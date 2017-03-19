package com.saramin.lab.search;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.PropertySource;

@EnableAutoConfiguration 
@SpringBootApplication
@PropertySource(value = {
        "classpath:config-${spring.profiles.active:prdt}.properties"
})
public class SearchApplication {

	public static void main(String[] args) {
		SpringApplication.run(SearchApplication.class, args);
	}
	
}
