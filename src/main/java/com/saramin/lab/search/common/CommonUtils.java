package com.saramin.lab.search.common;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

@Component
public class CommonUtils {

	@Autowired
	Environment env;

	public boolean isNull(String str){
		boolean b = true;
		if(str != null)
			b = false;
		return b;
	}

	public String null2Str(String str,String def){
		if(str == null){
			return def;
		}else{
			return str;
		}
	}


	public Object fileReadToCollection(String filepath, Object obj, String seper) {
		try {
			try (BufferedReader br = openFileForRead(filepath)) {
				String s = null;
				while ((s = br.readLine()) != null) {
					if (obj instanceof HashMap) {
						try {
							((HashMap<String, String>) obj).put(s.split(seper)[0].toLowerCase().trim(),
									s.split(seper)[1]);
						} catch (ArrayIndexOutOfBoundsException e) {
							continue;
						}
					} else {
						// else
					}
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return obj;
	}

	public BufferedReader openFileForRead(String fileName) throws Exception {
		return (new BufferedReader(new InputStreamReader(new FileInputStream(fileName),env.getProperty("dictionary.file.encoding"))));
	}



	/**
	 * List Type의 
	 * @param list
	 * @param rank
	 * @return
	 */
	public <T> List<T>   getRankList(List<T> list, int rank){
		ListIterator<T> it = list.listIterator();
		List<T> returnList = new LinkedList<T>();
		int cnt = 0;
		while(it.hasNext()){
			cnt ++;
			returnList.add((T)it.next());
			if(cnt == rank){
				break;
			}
		}
		return returnList;
	}



}
