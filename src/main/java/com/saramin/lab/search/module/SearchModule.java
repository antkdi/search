package com.saramin.lab.search.module;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Repository;

import com.konantech.konansearch.KSEARCH;
import com.saramin.lab.search.query.SearchQueryBuilder;
import com.saramin.lab.search.vo.SearchResultVO;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Repository
public class SearchModule {
	
	@Autowired
	Environment env;
	@Autowired
	KSEARCH ksearch;

	public SearchResultVO search(SearchQueryBuilder builder){

		
		KSEARCH ksearch = new KSEARCH();
		int rc = 0;
		long hc = ksearch.CreateHandle();
		
		ksearch.SetOption(hc, KSEARCH.OPTION_SOCKET_TIMEOUT_REQUEST, 5);
		
		ksearch.SetCharacterEncoding(hc, "UTF-8"); 
		
		ksearch.SetLog(hc, "[기타로그입니다]");
		
		log.info(builder.toString());
		try {
			rc = ksearch.Search(
								hc, 
								env.getProperty("engin.ip") + ":" + env.getProperty("engine.port"), 
								builder.getScenario(), 
								builder.getWhereClause().toString(), 
								builder.getSortingClause().toString(), 
								builder.getHighlightKwd(), 
								"LOG입니다.", 
								1, 
								10, 
								KSEARCH.LC_KOREAN, 
								KSEARCH.CS_UTF8);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			log.error("ERROR:"+ksearch.GetErrorMessage(hc),e);
		}
		
		if(rc <0){
			log.error("ERROR MSG :" + ksearch.GetErrorMessage(hc));
		}
		
		log.info("Call SearchModule({});",builder.getScenario());
		
		return new SearchResultVO();
	}
	
	
}
