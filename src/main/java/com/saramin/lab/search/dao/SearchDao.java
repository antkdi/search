package com.saramin.lab.search.dao;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Repository;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.saramin.lab.search.common.CommonUtils;
import com.saramin.lab.search.common.GlobalConstant;
import com.saramin.lab.search.module.RestSearchModule;
import com.saramin.lab.search.module.SearchModule;
import com.saramin.lab.search.param.SearchParameter;
import com.saramin.lab.search.query.SearchQueryBuilder;
import com.saramin.lab.search.vo.RestResultVO;
import com.saramin.lab.search.vo.SearchResultVO;

@Repository
public class SearchDao {

	@Autowired
	Environment env;

	@Autowired
	SearchModule module;

	@Autowired
	RestSearchModule restModule;
	
	@Autowired
	CommonUtils common;


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

		SearchQueryBuilder builder = new SearchQueryBuilder();
		if(param.getKwd() != null && param.getKwd().length() > 0){
			builder.setWhereClause(new StringBuffer("text_idx ='" +param.getKwd() + "' allword"));
		}
		if(param.getSort() != null){
			if(param.getSort().equals("r")){
				builder.setSortingClause(new StringBuffer("order by $relevance desc"));
			}
		}


		return module.search(builder);
	}
	
	public RestResultVO getSearchResultForRest(SearchParameter param){
		SearchQueryBuilder builder = new SearchQueryBuilder();
		String volNm = env.getProperty(GlobalConstant.REST_VOL_RECRUIT_UPJIK);
		String fields = env.getProperty(GlobalConstant.REST_FD_RECRUIT_UPJIK);
		String where = "";

		if(param.getKwd() != null && param.getKwd().length() > 0){
			builder.setWhereClause(new StringBuffer("text_idx ='" +param.getKwd() + "' allword"));
		}
		if(param.getSort() != null){
			if(param.getSort().equals("d")){
				builder.setSortingClause(new StringBuffer("order by opening_dt desc"));
			}
		}else{
			builder.setSortingClause(new StringBuffer("order by $relevance desc"));
		}

		where = builder.getWhereClause() + " " + builder.getSortingClause();

		return restModule.searchAPI(fields, volNm, where);
	}
	
	
	public RestResultVO getSearchResultForRestGroupBy(SearchParameter param){
		SearchQueryBuilder builder = new SearchQueryBuilder();
		String volNm = env.getProperty(GlobalConstant.REST_VOL_RECRUIT_UPJIK);
		String fields = "count(*)";
		String where = "";

		if(param.getKwd() != null && param.getKwd().length() > 0){
			builder.setWhereClause(new StringBuffer("text_idx ='" +param.getKwd() + "' allword group by jikjong_cd,jikjong_mcode"));
		}

		where = builder.getWhereClause().toString();

		return restModule.searchAPI(fields, volNm, where);
	}
	
	public RestResultVO getSearchResultForRestGroupByCount(SearchParameter param){
		SearchQueryBuilder builder = new SearchQueryBuilder();
		String volNm = env.getProperty(GlobalConstant.REST_VOL_RECRUIT_UPJIK);
		String fields = "count(*)";
		String where = "";

		if(param.getKwd() != null && param.getKwd().length() > 0){
			builder.setWhereClause(new StringBuffer("text_idx ='" +param.getKwd() + "' allword group by jikjong_cd"));
		}

		
		where = builder.getWhereClause().toString();

		return restModule.searchAPI(fields, volNm, where);
	}
	

}
