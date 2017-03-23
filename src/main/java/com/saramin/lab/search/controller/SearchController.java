package com.saramin.lab.search.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.saramin.lab.search.param.SearchParameter;
import com.saramin.lab.search.service.SearchService;
import com.saramin.lab.search.vo.RestResultVO;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class SearchController {
	
	@Autowired
	SearchService searchService;
	
	@Autowired
	Environment env;
	
	@RequestMapping("/search")
	public String index(Model model ,SearchParameter param) {
		model.addAttribute("name", "Spring");
		log.info("search Controller");
		log.info(env.getProperty("engine.ip"));
		RestResultVO result = searchService.getSearchResultForRest(param);
		return "search";
	}
	
	@RequestMapping("/test")
	public String test(Model model ,SearchParameter param) {
		model.addAttribute("name", "Spring");
		log.info("search Controller");
		log.info(env.getProperty("engine.ip"));
		//searchService.getSearchResult(param);
		
		log.info(param.toString());
		return "test";
	}

}
