package com.cym.model;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.lang.Nullable;

/** 
 * @description 
 * 
 * @author Yaman
 * @createDate 2020/06/02
 */
public class MyBeanPost implements BeanPostProcessor {
	@Override
	public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
		System.out.println("*) postProcessBeforeInitialization() ");
		return bean;
	}
	
	@Override
	public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
		System.out.println("*) postProcessAfterInitialization() ");
		return bean;
	}
}


