/**   
 * @author lihailong  
 * @date 2015年8月17日
 * @Description: 初始化数据库的某些数据，bean后处理器。
 * @version 1.0   
 */
package com.lhl.sw.util;

import java.util.Properties;

import javax.transaction.Transactional;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.context.annotation.DependsOn;
import org.springframework.stereotype.Service;
import org.springframework.web.context.ContextLoader;

import com.lhl.sw.dao.BaseDAO;
import com.lhl.sw.po.AttendType;
import com.lhl.sw.service.DataInitService;
import com.lhl.sw.service.EmpService;

@Service
public class DataInitProcessor implements BeanPostProcessor {
	/**
	 * bean初始化完成后的操作
	 * 
	 * @param bean
	 * 
	 * @param beanName
	 * 
	 * @return bean实例
	 */
	public Object postProcessAfterInitialization(Object bean, String beanName)
			throws BeansException {
		System.out.println("_________________" + beanName);
		if (bean instanceof DataInitService) {
			((DataInitService) bean).initAttendType();
		}

		return bean;
	}

	/**
	 * bean初始化之前的操作
	 * 
	 * @param bean
	 * 
	 * @param beanName
	 * 
	 * @return bean实例
	 */
	public Object postProcessBeforeInitialization(Object bean, String beanName)
			throws BeansException {
		return bean;
	}
}
