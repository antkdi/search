package com.saramin.lab.search.module;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLEncoder;
import java.text.MessageFormat;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Repository;

import com.saramin.lab.search.common.GlobalConstant;
import com.saramin.lab.search.vo.RestResultVO;

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
		
		RestResultVO restVO = new RestResultVO();
		//String apiUrl = "http://182.162.109.118:6166/search";
		String apiUrl = env.getProperty("rest.url");

		try {
			apiUrl += MessageFormat.format("select={0}&from={1}&where={2}", 
											selectStr, 
											fromStr, 
											URLEncoder.encode(whereStr,"UTF-8"));
			log.info("URL:"+ apiUrl);
			BufferedReader reader;
			reader = getBufferedReader(apiUrl);
			StringBuffer jsonStr = readerToStrBuff(reader);
			
			JSONParser parser = new JSONParser();
			Object obj;
			obj = parser.parse(jsonStr.toString());
			
			JSONObject jsonObj = (JSONObject) obj;
			restVO.setStatus((String)jsonObj.get("status"));
			
			if(restVO.getStatus().equals("Failed")){
				throw new IOException("Konan Rest Search Failed:" + (String)jsonObj.get("message"));
			}
			
			JSONObject resultObj = (JSONObject) jsonObj.get("result");
			restVO.setTotal((long)resultObj.get("total_count"));
			
			JSONArray arr = (JSONArray) resultObj.get("rows");
			
			return restVO;

		} catch (IOException e ) {
			e.printStackTrace();
		} catch (ParseException e) {
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
	
	public StringBuffer readerToStrBuff(BufferedReader reader) {
		StringBuffer sb = new StringBuffer();
		String tmp;
		try {
			while ( (tmp = reader.readLine()) != null){
				sb.append(tmp);
				sb.append(System.lineSeparator());
			}
		} catch (IOException e) {
			log.error("BufferRead Error : ",e);
		}
		
		return sb;
	}

}
