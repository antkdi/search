package com.saramin.lab.search.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.saramin.lab.search.service.SearchService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class SearchController {
	
	@Autowired
	SearchService searchService;
	
	@Autowired
	Environment env;
	
	@RequestMapping("/search")
	public String index(Model model) {
		model.addAttribute("name", "SpringBlog from Millky");
		log.info("search Controller");
		searchService.getSearchResult(env.getProperty("config"));
		return "search";
	}

}
