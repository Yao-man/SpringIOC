package com.cym.model;

import org.springframework.beans.factory.FactoryBean;

/** 
 * @description 
 * 
 * @author Yaman
 * @createDate 2020/06/01
 */
public class MyFactoryBean implements FactoryBean<Student> {

	@Override
	public Student getObject() throws Exception {
		Student stu = new Student();
		//...
		return stu;
	}

	@Override
	public Class<?> getObjectType() {
		return null;
	}
	
	@Override
	public boolean isSingleton() {
		//对象是否为单例 默认true
		return false;
	}
}


