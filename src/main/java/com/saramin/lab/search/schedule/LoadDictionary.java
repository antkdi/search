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
		setConstantMap(GlobalConstant.JIK_MCODE_CD_MAP,env.getProperty("recruit.jikcd.path"),":");
		setConstantMap(GlobalConstant.JIK_MCODE_NM_MAP,env.getProperty("recruit.jiknm.path"),":");
		setConstantMap(GlobalConstant.JIK_BCODE_NM_MAP,env.getProperty("recruit.jiknm.path"),":");
		setConstantMap(GlobalConstant.AREA_BCODE_MAP,env.getProperty("recruit.barea.cd"),":");
		setConstantMap(GlobalConstant.AREA_BCODE_NM_MAP,env.getProperty("recruit_barea.nm"),":");
		setConstantMap(GlobalConstant.AREA_MCODE_MAP,env.getProperty("recruit.marea.cd"),":");
		setConstantMap(GlobalConstant.AREA_MCODE_NM_MAP,env.getProperty("recruit.marea.nm"),":");
	}
	
	public <K,V> void setConstantMap(HashMap<K,V> repo, String filePath, String deli){
		repo.clear();
		common.fileReadToCollection(filePath, repo, deli);
	}
	

}
