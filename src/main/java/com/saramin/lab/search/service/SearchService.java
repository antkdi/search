package com.saramin.lab.search.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.saramin.lab.search.dao.SearchDao;
import com.saramin.lab.search.param.SearchParameter;
import com.saramin.lab.search.vo.SearchResultVO;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service("searchService")
public class SearchService {
	
	@Autowired
	SearchDao searchDao;

	public SearchResultVO getSearchResult(SearchParameter param){
		return searchDao.getSearchResultForAPI(param);
	}
}
