package com.saramin.lab.search.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.saramin.lab.search.module.SearchModule;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service("searchService")
public class SearchService {
	
	@Autowired
	SearchModule module;

	public void getSearchResult(String a){
	
		log.info("Search Result!!!");
		module.dcSearch(a);
	}
}
