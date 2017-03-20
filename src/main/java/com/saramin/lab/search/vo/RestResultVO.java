package com.saramin.lab.search.vo;

import java.util.ArrayList;
import java.util.HashMap;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RestResultVO {
	
	private String status;
	private String message;
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
