package com.cym.service;

import org.springframework.stereotype.Service;

/** 
 * @description 
 * 
 * @author Yaman
 * @createDate 2020/06/02
 */
@Service(value = "selfDefineName")//自定义名称
public class UserService {

	public void test() {
		System.out.println("selfDefineName");
	}
}


