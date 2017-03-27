package com.saramin.lab.search.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

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
	
	public RestResultVO getSearchResultGroupBy(SearchParameter param,String groupKey){
		
		RestResultVO result = new RestResultVO();
		result = restDao.getSearchResultGroupBy(param,groupKey);
		return result;
	}
	
	public List<List<HashMap<String,String>>> getInnerGroupBy(SearchParameter param,List<?> rankResult,String groupKey){
		RestResultVO result = new RestResultVO();
		List<List<HashMap<String,String>>> returnList = new ArrayList<List<HashMap<String,String>>>();
		for(HashMap<String,String> rankResultMap : (List<HashMap<String,String>>)rankResult){
			List<HashMap<String,String>> bigGroupList = new ArrayList<HashMap<String,String>>();
			String bigGroupKey = rankResultMap.get("jikjong_cd");
			result = restDao.getInnerResultGroupBy(param, bigGroupKey,groupKey);
			for(HashMap<String,String> innerMap : result.getResult()){
				HashMap<String,String> tmpMap = new HashMap<String,String>();
				tmpMap.put("GroupKey", bigGroupKey);
				tmpMap.put(groupKey, innerMap.get(groupKey));
				tmpMap.put("cnt", innerMap.get("cnt"));
				bigGroupList.add(tmpMap);
			}
			returnList.add(bigGroupList);
		}
		return returnList;
		
		
	}
}
