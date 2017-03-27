package com.saramin.lab.search.vo;

import java.util.HashMap;
import java.util.List;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.extern.slf4j.Slf4j;

@Slf4j 
@Getter
@Setter
@ToString
public class RestResultVO {
	
	private String status;
	private long total;
	private int rows;
	
	private List<HashMap<String, String>> result;
	
}
