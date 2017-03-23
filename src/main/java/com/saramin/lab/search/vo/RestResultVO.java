package com.saramin.lab.search.vo;

import java.util.ArrayList;
import java.util.HashMap;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RestResultVO {
	
	@JsonProperty("status")
	private String status;
	@JsonProperty("message")
	private String message;
	@JsonProperty("result")
	private HashMap<String, Object> result;

	@SuppressWarnings("unchecked")
	public ArrayList<HashMap<String, Object>> getRows() {
		return (ArrayList<HashMap<String, Object>>) getResult().get("rows");
	}
	
	public int getRowsCount() {
		return getRows().size();
	}
	
	@SuppressWarnings("unchecked")
	public HashMap<String, Object> getFirstRow() {
		return (HashMap<String, Object>) getRows().get(0).get("fields");
	}

}
