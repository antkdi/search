package com.saramin.lab.search.param;

import org.springframework.stereotype.Component;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@RequiredArgsConstructor
@Component
public class SearchParameter {

	String originKwd;
	String kwd;
	int pageNum;
	int pageSize;
	String sort;
}