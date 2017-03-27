package com.saramin.lab.search;

import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.http.converter.FormHttpMessageConverter;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.web.client.RestTemplate;

import com.konantech.konansearch.KSEARCH;

@Configuration
public class SearchConfig {
	
	@Autowired
	Environment env;
	
	@Bean 
	public KSEARCH getSearchContext(){
		KSEARCH ksearch = new KSEARCH();
		return ksearch;
	}
	
	@Bean
	public RestTemplate getRestTemplate(){
		RestTemplate restTemplate = new RestTemplate();
		List<HttpMessageConverter<?>> converters = new ArrayList<HttpMessageConverter<?>>();
		converters.add(new FormHttpMessageConverter());
		converters.add(new StringHttpMessageConverter(Charset.forName(env.getProperty("restTemplate.charset"))));
		restTemplate.setMessageConverters(converters);
		return restTemplate;
	}

}
