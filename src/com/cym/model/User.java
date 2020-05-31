package com.cym.model;

/**
 * @description
 * 
 * @author Yaman
 * @createDate 2020/05/31
 */
public class User {

	private String name, gender;
	private short age;

	public User(String name, String gender, short age) {
		super();
		this.name = name;
		this.gender = gender;
		this.age = age;
	}

	public User() {
		super();
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public short getAge() {
		return age;
	}

	public void setAge(short age) {
		this.age = age;
	}

	@Override
	public String toString() {
		return "User [name=" + name + ", gender=" + gender + ", age=" + age + "]";
	}
	
	public void display() {
		System.out.println(this);
	}
}
