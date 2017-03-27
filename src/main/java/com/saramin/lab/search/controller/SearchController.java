package com.saramin.lab.search.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.saramin.lab.search.common.CommonUtils;
import com.saramin.lab.search.common.GlobalConstant;
import com.saramin.lab.search.param.SearchParameter;
import com.saramin.lab.search.service.FilterService;
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
	FilterService filterService;
	
	@Autowired
	CommonUtils common;
	
	@Autowired
	Environment env;
	
	@RequestMapping("/search")
	public String index(Model model ,SearchParameter param) {
		
		RestResultVO result = new RestResultVO();
		if(param.getKwd().length() > 0){
			setFilterInfo(model,param);
			result = restService.getSearchResult(param);
		}
		
		if(result != null){
			model.addAttribute("resultList",result.getResult());
			model.addAttribute("resultCount",result.getTotal());
			log.info("do It!");
		}
		model.addAttribute("searchParam",param);
		
		
		log.info(result.toString());
		
		return "search";
		
	}
	
	private void setFilterInfo(Model model, SearchParameter param){
		RestResultVO jikjongResult;
		RestResultVO locationResult;
		
		//Group by Result
		jikjongResult = restService.getSearchResultGroupBy(param,env.getProperty("group.key.jikjong"));
		locationResult = restService.getSearchResultGroupBy(param,env.getProperty("group.key.location"));
		
		//Rank 5
		List<HashMap<String,String>> rank_jikjong = common.getRankList(jikjongResult.getResult(),5);
		List<HashMap<String,String>> rank_location = common.getRankList(locationResult.getResult(),5);
		
		List<List<HashMap<String,String>>> jikjong_description = restService.getInnerGroupBy(param, rank_jikjong,env.getProperty("group.key.jikjong.description")); 
		log.info(">>>>>>>>>>>>>>>>>>>>>>:"+jikjong_description.toString());
		model.addAttribute("jikjongList", rank_jikjong);
		model.addAttribute("locationList", rank_location);
		model.addAttribute("jikjongTotal",jikjongResult.getTotal());
		model.addAttribute("locationTotalTotal",locationResult.getTotal());
		model.addAttribute("subjikjongList",jikjong_description);
		
	}

}
