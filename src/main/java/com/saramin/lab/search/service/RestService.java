package com.saramin.lab.search.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

import com.saramin.lab.search.dao.RestDao;
import com.saramin.lab.search.param.SearchParameter;
import com.saramin.lab.search.vo.RestResultVO;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service("restService")
public class RestService {
	
	@Autowired
	Environment env;
	@Autowired
	RestDao restDao;

	public RestResultVO getSearchResult(SearchParameter param) {
		
		RestResultVO result = new RestResultVO();
		if(param.getKwd().length() > 0){
				result = restDao.getSearchResult(param);
		}
		return result;
	}
	
	public RestResultVO getSearchResultGroupBy(SearchParameter param){
		
		RestResultVO result = new RestResultVO();
		result = restDao.getSearchResultGroupBy(param);
		return result;
	}
}
