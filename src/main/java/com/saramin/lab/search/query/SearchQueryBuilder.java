package com.saramin.lab.search.query;

import org.springframework.stereotype.Component;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Component
@Getter
@Setter
@ToString
public class SearchQueryBuilder {
	
	private StringBuffer whereClause;
	private StringBuffer sortingClause;
	private String highlightKwd;
	private String searchkwd;
	private String selectCloumn;
	private String from;
	private int startOffset;
	private int pageSize;
	private int language;
	private int characterSet;
	private String scenario;
	
	
	public void init(){
		this.whereClause = new StringBuffer();
		this.sortingClause = new StringBuffer();
		this.highlightKwd = "";
		this.searchkwd ="";
		this.scenario ="";
	}
	
}
