package com.saramin.lab.search.schedule;

import java.util.HashMap;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

import com.saramin.lab.search.common.CommonUtils;
import com.saramin.lab.search.common.GlobalConstant;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component 
public class LoadDictionary {
	
	@Autowired
	Environment env;
	
	@Autowired
	CommonUtils common;
	
	@PostConstruct
	public void loadDictionary(){
		log.info("Start Load Dictionary.");
		GlobalConstant.JIK_MCODE_CD_MAP = getJikjongMap(env.getProperty("recruit.jikcd.path"),":");
		GlobalConstant.JIK_MCODE_NM_MAP = getJikjongMap(env.getProperty("recruit.jiknm.path"),":");
		log.info("Compleate Load Dictionary.");
	}
	
	public HashMap<String,String> getJikjongMap(String filePath,String deli){
		HashMap<String,String> tmpMap = new HashMap<String,String>();
		return (HashMap<String, String>) common.fileReadToCollection(filePath, tmpMap, deli);
	}

}
