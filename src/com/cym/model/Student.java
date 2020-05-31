package com.cym.model;

import java.util.List;
import java.util.Map;

/** 
 * @description 
 * 
 * @author Yaman
 * @createDate 2020/06/01
 */
public class Student {
	Map<String, String> cources;
	List<Integer> grand;
	public Map<String, String> getCources() {
		return cources;
	}
	public void setCources(Map<String, String> cources) {
		this.cources = cources;
	}
	public List<Integer> getGrand() {
		return grand;
	}
	public void setGrand(List<Integer> grand) {
		this.grand = grand;
	}
	
}


