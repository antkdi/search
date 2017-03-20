package com.saramin.lab.search;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.konantech.konansearch.KSEARCH;

@Configuration
public class SearchConfig {
	
	@Bean 
	public KSEARCH getSearchContext(){
		KSEARCH ksearch = new KSEARCH();
		return ksearch;
	}

}
