package com.saramin.lab.search.module;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLEncoder;
import java.text.MessageFormat;

import org.codehaus.jackson.JsonParser;
import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Repository;

import com.saramin.lab.search.common.GlobalConstant;
import com.saramin.lab.search.vo.RestResultVO;
import com.saramin.lab.search.vo.SearchResultVO;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Repository
public class RestSearchModule {
	
	@Autowired
	Environment env;
	
	
	/**
	 * searchAPI (selectColumn, fromString, whereString)
	 * @param selectStr
	 * @param fromStr
	 * @param whereStr
	 * @return
	 */
	public RestResultVO searchAPI(String selectStr, String fromStr, String whereStr) {
		
		//String apiUrl = "http://182.162.109.118:6166/search";
		String apiUrl = env.getProperty("rest.url");

		try {
			apiUrl += MessageFormat.format("select={0}&from={1}&where={2}", 
											selectStr, 
											fromStr, 
											URLEncoder.encode(whereStr,"UTF-8"));
			log.info("URL:"+ apiUrl);
			BufferedReader reader;
			if(env.getProperty("connect.mode").equals("home")){
				reader = new BufferedReader(new InputStreamReader(new FileInputStream(new File(env.getProperty("home.file"))),"UTF-8"));
			}else{
				reader = getBufferedReader(apiUrl);
			}
			ObjectMapper mapper = new ObjectMapper();
			mapper.configure(JsonParser.Feature.ALLOW_UNQUOTED_FIELD_NAMES, true);
			//mapper.configure(JsonParser.Feature.ALLOW_UNQUOTED_CONTROL_CHARS, true);
			
			RestResultVO resultVO = mapper.readValue(reader, RestResultVO.class);
			reader.close();
			
			return resultVO;

		} catch (IOException e ) {
			e.printStackTrace();
		} 
		return null;
	}
	
	
	
	public BufferedReader getBufferedReader(String apiUrl) {
		try {
			URL url = new URL(apiUrl);
			return new BufferedReader(new InputStreamReader(url.openStream(),GlobalConstant.CHARSET_UTF8));
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}

}
