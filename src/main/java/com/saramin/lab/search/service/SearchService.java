package com.saramin.lab.search.service;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.saramin.lab.search.dao.SearchDao;
import com.saramin.lab.search.param.SearchParameter;
import com.saramin.lab.search.vo.RestResultVO;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service("searchService")
public class SearchService {
	
	@Autowired
	Environment env;
	@Autowired
	SearchDao searchDao;

	public RestResultVO getSearchResultForRest(SearchParameter param) {
		
		RestResultVO result = new RestResultVO();
		if(param.getKwd().length() > 0){
				result = searchDao.getSearchResultForRest(param);
		}
		return result;
	}
}
