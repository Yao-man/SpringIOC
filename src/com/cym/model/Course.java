package com.cym.model;

/** 
 * @description 
 * 
 * @author Yaman
 * @createDate 2020/06/01
 */
public class Course {
	
	private String cName,tName;

	public Course(String cName, String tName) {
		super();
		this.cName = cName;
		this.tName = tName;
	}

	public Course() {
		super();
	}

	public String getcName() {
		return cName;
	}

	public void setcName(String cName) {
		this.cName = cName;
	}

	public String gettName() {
		return tName;
	}

	public void settName(String tName) {
		this.tName = tName;
	}

	@Override
	public String toString() {
		return "{course: " + cName + ", teacher: " + tName + "}";
	}
	
}


