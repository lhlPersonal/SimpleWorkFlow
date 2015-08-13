/**   
 * @author lihailong
 * @date 2015-5-13  
 * @Description: common methods for project. 
 * @version 1.0   
 */
package com.lhl.sw.util;

import java.util.Optional;

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
}
