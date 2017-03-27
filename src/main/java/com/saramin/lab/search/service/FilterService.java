package com.saramin.lab.search.service;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

import com.saramin.lab.search.vo.RestResultVO;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service("filterService")
public class FilterService {
	
	@Autowired
	Environment env;

	public List<HashMap<String,String>> getTopList(RestResultVO result,int rank){
		List<HashMap<String,String>> tmpList = new LinkedList<HashMap<String,String>>();
		for(int i=0 ; i < rank; i ++){
			HashMap<String,String> map = result.getResult().get(i);
			tmpList.add(map);
		}
		return tmpList;
	}
}
