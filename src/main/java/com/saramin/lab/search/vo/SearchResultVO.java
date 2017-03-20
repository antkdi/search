package com.saramin.lab.search.vo;

import java.util.HashMap;
import java.util.List;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SearchResultVO {
	
	//Result List
	private List<HashMap<String,String>> resultList;
	//CNT
	private int total;
	
	
}
