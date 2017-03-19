package com.saramin.lab.search.param;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@RequiredArgsConstructor
public class SearchParameter {

	String kwd;
	int pageNum;
	int pageSize;
	String docId;
}