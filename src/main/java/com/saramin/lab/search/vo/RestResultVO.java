package com.saramin.lab.search.vo;

import java.util.ArrayList;
import java.util.HashMap;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.extern.slf4j.Slf4j;

@Slf4j 
@Getter
@Setter
@ToString
public class RestResultVO {
	
	@JsonProperty("status")
	private String status;
	
	@JsonProperty("message")
	private String message;
	
	@JsonProperty("result")
	private HashMap<String, Object> result;

	@SuppressWarnings("unchecked")
	public ArrayList<HashMap<String, Object>> getRows() {
		HashMap<String,Object> result = getResult();
		if(result == null)
			return new ArrayList<HashMap<String,Object>>();
		
		return (ArrayList<HashMap<String, Object>>) result.get("rows");
	}
	
	public int getRowsCount() {
		return getRows().size();
	}
	
	@SuppressWarnings("unchecked")
	public HashMap<String, Object> getFirstRow() {
		return getRows().size()>0 ? (HashMap<String, Object>) getRows().get(0).get("fields") : new HashMap<String,Object>();
	}
	
	public int getTotalCount() {
		return (int)getResult().get("total_count");
	}

}
