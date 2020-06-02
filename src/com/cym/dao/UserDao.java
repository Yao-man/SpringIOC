package com.cym.dao;

import org.springframework.stereotype.Repository;

/** 
 * @description 
 * 
 * @author Yaman
 * @createDate 2020/06/02
 */
@Repository(value = "userDao")//value 自动 / 默认 将类名首字母小写    此处value相当于<bean id="userDao" class="com.cym.dao.UserDao" />
public class UserDao {

	private String name;
	public void test() {
		System.out.println("userDao");
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
}


