package com.saramin.lab.search.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.saramin.lab.search.param.SearchParameter;
import com.saramin.lab.search.service.RestService;
import com.saramin.lab.search.service.SearchService;
import com.saramin.lab.search.vo.RestResultVO;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class SearchController {
	
	@Autowired
	SearchService searchService;
	
	@Autowired
	RestService restService;
	
	@Autowired
	Environment env;
	
	@RequestMapping("/search")
	public String index(Model model ,SearchParameter param) {
		
		RestResultVO result = new RestResultVO();
		if(param.getKwd().length() > 0){
			result = restService.getSearchResult(param);
			setFilterInfo(param);
		}
		
		if(result != null){
			model.addAttribute("resultList",result.getResult());
			model.addAttribute("resultCount",result.getTotal());
		}
		model.addAttribute("searchParam",param);
		
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
	
	private void setFilterInfo(SearchParameter param){
		RestResultVO result;
		result = restService.getSearchResultGroupBy(param);
		log.info("GroupBy Result:>>>>>>>>>>>>>>>");
		log.info("<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<");
	}

}
