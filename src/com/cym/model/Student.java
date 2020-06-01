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
	Map<String, Course> cources;
	List<Integer> report;
	public Map<String, Course> getCources() {
		return cources;
	}
	public void setCources(Map<String, Course> cources) {
		this.cources = cources;
	}
	public List<Integer> getReport() {
		return report;
	}
	public void setReport(List<Integer> report) {
		this.report = report;
	}
	@Override
	public String toString() {
		return "Student [cources=" + cources + ", report=" + report + "]";
	}
	
	
	
}


