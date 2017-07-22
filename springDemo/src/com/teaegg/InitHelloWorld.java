package com.teaegg;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
/**
 * BeanPostProcessor/
 * spring 发布处理器：
 * 在bean的初始化之前和之后 进行处理
 * @author twx
 *
 */
public class InitHelloWorld implements BeanPostProcessor{

	@Override
	public Object postProcessAfterInitialization(Object bean, String beanname) throws BeansException {
		// TODO Auto-generated method stub
		System.out.println("AfterInitialization:"+beanname);
		return bean;
	}

	@Override
	public Object postProcessBeforeInitialization(Object bean, String beanname) throws BeansException {
		// TODO Auto-generated method stub
		System.out.println("BeforInitialization:"+beanname);
		return bean;
	}
	
}
