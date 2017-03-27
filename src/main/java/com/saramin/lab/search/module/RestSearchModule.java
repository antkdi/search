package com.saramin.lab.search.module;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Repository;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import com.saramin.lab.search.common.CommonUtils;
import com.saramin.lab.search.common.GlobalConstant;
import com.saramin.lab.search.query.SearchQueryBuilder;
import com.saramin.lab.search.vo.RestResultVO;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Repository
public class RestSearchModule {
	
	@Autowired
	Environment env;
	
	@Autowired
	RestTemplate restTemplate;
	
	@Autowired
	CommonUtils common;
	
	
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
			
			MultiValueMap<String,String> paramMap = new LinkedMultiValueMap<String,String>();
			paramMap.add("select", selectStr);
			paramMap.add("from", fromStr);
			paramMap.add("where", whereStr);
				
			String rest = restTemplate.postForObject(apiUrl, paramMap, String.class);
			
			JSONObject jsonObj = (JSONObject) new JSONParser().parse(rest.toString());
			restVO.setStatus((String)jsonObj.get("status"));
			log.info(jsonObj.toJSONString());
			if(restVO.getStatus().equals("Failed")){
				throw new IOException("Konan Rest Search Failed:" + (String)jsonObj.get("message"));
			}
			
			JSONObject resultObj = (JSONObject) jsonObj.get("result");
			restVO.setTotal((long)resultObj.get("total_count"));
			
			JSONArray arr = (JSONArray) resultObj.get("rows");
			int arrCnt = arr.size();
			int fieldCnt = 0;
			
			if(arr != null && arrCnt > 0) {
				String[] fields = selectStr.split(",");
				HashMap<String, String> map;
				List<HashMap<String, String>> list = new ArrayList<HashMap<String, String>> (); 
				JSONObject result;
				JSONObject record;
				fieldCnt = fields.length;
				for(int i=0; i<arrCnt; i++) {
					map = new HashMap<String, String> ();
					
					result = (JSONObject) arr.get(i);
					record = (JSONObject) result.get("fields");
					
					for(int j=0; j<fieldCnt; j++) {
							//log.info(fields[j].toString() + " ::::" + record.get(fields[j]).toString());
							map.put(fields[j], String.valueOf(record.get(fields[j])));
					}
					
					list.add(map);
					map = null;
				}
				
				restVO.setResult(list);
			}
			// 파싱 끝			
			
			return restVO;

		} catch (IOException e ) {
			e.printStackTrace();
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	/**
	 * searchAPI (selectColumn, fromString, whereString)
	 * @param selectStr
	 * @param fromStr
	 * @param whereStr
	 * @return
	 */
	public RestResultVO searchAPI(String selectStr, String fromStr, String whereStr,String limit) {
		
		RestResultVO restVO = new RestResultVO();
		//String apiUrl = "http://182.162.109.118:6166/search";
		String apiUrl = env.getProperty("rest.url");

		try {
			
			MultiValueMap<String,String> paramMap = new LinkedMultiValueMap<String,String>();
			paramMap.add("select", selectStr);
			paramMap.add("from", fromStr);
			paramMap.add("where", whereStr);
			paramMap.add("limit", limit);
				
			String rest = restTemplate.postForObject(apiUrl, paramMap, String.class);
			
			JSONObject jsonObj = (JSONObject) new JSONParser().parse(rest.toString());
			restVO.setStatus((String)jsonObj.get("status"));
			log.info(jsonObj.toJSONString());
			if(restVO.getStatus().equals("Failed")){
				throw new IOException("Konan Rest Search Failed:" + (String)jsonObj.get("message"));
			}
			
			JSONObject resultObj = (JSONObject) jsonObj.get("result");
			restVO.setTotal((long)resultObj.get("total_count"));
			
			JSONArray arr = (JSONArray) resultObj.get("rows");
			int arrCnt = arr.size();
			int fieldCnt = 0;
			
			if(arr != null && arrCnt > 0) {
				String[] fields = selectStr.split(",");
				HashMap<String, String> map;
				List<HashMap<String, String>> list = new ArrayList<HashMap<String, String>> (); 
				JSONObject result;
				JSONObject record;
				fieldCnt = fields.length;
				for(int i=0; i<arrCnt; i++) {
					map = new HashMap<String, String> ();
					
					result = (JSONObject) arr.get(i);
					record = (JSONObject) result.get("fields");
					
					for(int j=0; j<fieldCnt; j++) {
							//log.info(fields[j].toString() + " ::::" + record.get(fields[j]).toString());
							if(fields[j].equals("count(*)")){
								map.put("cnt", String.valueOf(record.get(fields[j])));
							}else if(fields[j].equals("area_bcode")){
								map.put(fields[j], String.valueOf(record.get(fields[j])));
								map.put("area_bcode_nm",GlobalConstant.AREA_BCODE_NM_MAP.get(String.valueOf(record.get(fields[j]))));
								map.put("area_mcode_nm",GlobalConstant.AREA_MCODE_MAP.get(String.valueOf(record.get(fields[j])).substring(0,3)+"000"));
							}else if(fields[j].equals("jikjong_cd")){
								map.put(fields[j], String.valueOf(record.get(fields[j])));
								map.put("jikjong_nm", GlobalConstant.JIK_BCODE_NM_MAP.get(String.valueOf(record.get(fields[j]))));
							}else{
								map.put(fields[j], String.valueOf(record.get(fields[j])));
							}
							
					}
					
					list.add(map);
					map = null;
				}
				
				restVO.setResult(list);
			}
			
			return restVO;

		} catch (IOException e ) {
			e.printStackTrace();
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	/**
	 * searchAPI (selectColumn, fromString, whereString)
	 * @param selectStr
	 * @param fromStr
	 * @param whereStr
	 * @return
	 */
	public RestResultVO searchAPI(SearchQueryBuilder query) {
		
		RestResultVO restVO = new RestResultVO();
		//String apiUrl = "http://182.162.109.118:6166/search";
		String apiUrl = env.getProperty("rest.url");

		try {
			
			MultiValueMap<String,String> paramMap = new LinkedMultiValueMap<String,String>();
			paramMap.add("select", query.getSelectCloumn());
			paramMap.add("from", query.getFrom());
			paramMap.add("where", common.null2Str(query.getWhereClause().toString(), "")   +" " + common.null2Str(query.getSortingClause().toString(),"") );
			paramMap.add("limit", String.valueOf(query.getPageSize()));
				
			String rest = restTemplate.postForObject(apiUrl, paramMap, String.class);
			
			JSONObject jsonObj = (JSONObject) new JSONParser().parse(rest.toString());
			restVO.setStatus((String)jsonObj.get("status"));
			log.info(jsonObj.toJSONString());
			if(restVO.getStatus().equals("Failed")){
				throw new IOException("Konan Rest Search Failed:" + (String)jsonObj.get("message"));
			}
			
			JSONObject resultObj = (JSONObject) jsonObj.get("result");
			restVO.setTotal((long)resultObj.get("total_count"));
			
			JSONArray arr = (JSONArray) resultObj.get("rows");
			int arrCnt = arr.size();
			int fieldCnt = 0;
			
			if(arr != null && arrCnt > 0) {
				String[] fields = query.getSelectCloumn().split(",");
				HashMap<String, String> map;
				List<HashMap<String, String>> list = new ArrayList<HashMap<String, String>> (); 
				JSONObject result;
				JSONObject record;
				fieldCnt = fields.length;
				for(int i=0; i<arrCnt; i++) {
					map = new HashMap<String, String> ();
					
					result = (JSONObject) arr.get(i);
					record = (JSONObject) result.get("fields");
					
					for(int j=0; j<fieldCnt; j++) {
							//log.info(fields[j].toString() + " ::::" + record.get(fields[j]).toString());
							if(fields[j].equals("count(*)")){
								map.put("cnt", String.valueOf(record.get(fields[j])));
							}else if(fields[j].equals("area_bcode")){
								map.put(fields[j], String.valueOf(record.get(fields[j])));
								map.put("area_bcode_nm",GlobalConstant.AREA_BCODE_NM_MAP.get(String.valueOf(record.get(fields[j]))));
								map.put("area_mcode_nm",GlobalConstant.AREA_MCODE_MAP.get(String.valueOf(record.get(fields[j])).substring(0,3)+"000"));
							}else if(fields[j].equals("jikjong_cd")){
								map.put(fields[j], String.valueOf(record.get(fields[j])));
								map.put("jikjong_nm", GlobalConstant.JIK_BCODE_NM_MAP.get(String.valueOf(record.get(fields[j]))));
							}else{
								map.put(fields[j], String.valueOf(record.get(fields[j])));
							}
							
					}
					
					list.add(map);
					map = null;
				}
				
				restVO.setResult(list);
			}
			
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
