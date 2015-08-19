/**   
 * @author lihailong
 * @date 2015-5-13  
 * @Description: common methods for project. 
 * @version 1.0   
 */
package com.lhl.sw.util;

import java.text.MessageFormat;
import java.util.Optional;
import java.util.Properties;

import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PropertiesLoaderUtils;

import com.opensymphony.xwork2.ActionContext;

public class Util {
	/**
	 * 验证字符串是否为空
	 * 
	 * @param s
	 *            字符串
	 */
	public static boolean isNullOrEmpty(String s) {
		return s.equals("") || !Optional.of(s).isPresent();
	}

	/**
	 * 获取properties文件
	 * 
	 * @param fileName
	 * @return properties file
	 */
	public static Properties getPorperties(String fileName) {
		try {
			Resource resource = new ClassPathResource(MessageFormat.format(
					"{0}.properties", fileName));
			Properties props = PropertiesLoaderUtils.loadProperties(resource);

			return props;

		} catch (Exception e) {

			return null;
			// TODO: handle exception
		}
	}

	/**
	 * 获取user id
	 * 
	 * @return user id
	 */
	public static int getUserId() {
		return Integer.valueOf(String.valueOf(ActionContext.getContext()
				.getSession().get(Constant.USER_ID)));

	}
}
