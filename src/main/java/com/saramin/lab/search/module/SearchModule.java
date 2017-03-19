package com.saramin.lab.search.module;

import org.springframework.stereotype.Repository;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Repository
public class SearchModule {

	public void dcSearch(String a){
		log.info("Call SearchModule({});",a);
	}
}
