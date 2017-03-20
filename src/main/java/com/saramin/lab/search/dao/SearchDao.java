package com.saramin.lab.search.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.saramin.lab.search.module.SearchModule;
import com.saramin.lab.search.param.SearchParameter;
import com.saramin.lab.search.param.SearchQueryBuilder;
import com.saramin.lab.search.vo.SearchResultVO;

@Repository
public class SearchDao {
	
	@Autowired
	SearchModule module;
	
	@Autowired
	SearchQueryBuilder builder;
	
	public SearchResultVO getSearchResultForAPI(SearchParameter param){
		
		
		/*// set scenario
		recruitUpjikList.setScenario();

		// set search keyword
		//recruitUpjikList.setSearchKeyword();
		
		
		// keyword type : upjik or company
		recruitUpjikList.setKeywordType();
		
		// make basic search query
		recruitUpjikList.setQryBasic();
		
		// make high search query
		recruitUpjikList.setQryComInfoHighInclude();
		recruitUpjikList.setQryComInfoHighExcept();
					
		// condition check & make query
		recruitUpjikList.setQryCondition();
					
		// company check & make query
		recruitUpjikList.setQryCompany();
					
		recruitUpjikList.setQryPeriod();
					
		// employ check & make query
		recruitUpjikList.setQryEmploye();
					
		// area
		recruitUpjikList.setQryArea();
								
		recruitUpjikList.setQryAreaBCode();
		
		// job category
		recruitUpjikList.setQryJobCategory();
		
		recruitUpjikList.setQryJikjongCd();
		
		recruitUpjikList.setQryJobType();
		
		// make order by
		if(defaultOrder.equals("false")){
			recruitUpjikList.setQryOrderBy();
		}else{
			recruitUpjikList.defaultOrderBy();
		}
		
		// set search (String scenario, String whereString, String sortString,
		// int offset, int limit, String highlightingText)
		recruitUpjikList.setSearchQuery();

		// debug ( scenario || where || order by )
		//ct2.setDebugMsg();
		
		// search log write
		recruitUpjikList.setSearchLog();
		return recruitUpjikList.getResult("lvs");*/
		
		builder.init();
		if(param.getKwd() != null && param.getKwd().length() > 0){
			builder.setWhereClause(new StringBuffer("text_idx ='" +param.getKwd() + "' allword"));
		}
		if(param.getSort() != null){
			if(param.getSort().equals("r")){
				builder.setSortingClause(new StringBuffer("order by $relevance desc"));
			}
		}
		
		builder.setScenario("abbd");
		SearchResultVO result = null; 
		//result = module.search(builder);
		return result;
	}

}