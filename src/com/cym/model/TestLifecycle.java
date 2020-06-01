package com.cym.model;

/**
 * @description
 * 
 * @author Yaman
 * @createDate 2020/06/02
 */
public class TestLifecycle {

	private String name;

	public TestLifecycle() {
		super();
		System.out.println("第一步:执行构造器");
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
		System.out.println("第二步:set方法");
	}

	public void selfInitMethod() {
		System.out.println("第三步:自定义初始化方法");
	}

	public void selfDestroyMethod() {
		System.out.println("第五步:自定义销毁方法");
	}
}
