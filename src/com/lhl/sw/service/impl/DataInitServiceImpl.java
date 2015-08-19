/**   
 * @author lihailong  
 * @date 2015年8月19日
 * @Description: 数据初始化类
 * @version 1.0   
 */
package com.lhl.sw.service.impl;

import java.util.List;
import java.util.Properties;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lhl.sw.dao.BaseDAO;
import com.lhl.sw.po.AttendType;
import com.lhl.sw.service.DataInitService;
import com.lhl.sw.util.Util;

@Service
@Transactional
public class DataInitServiceImpl implements DataInitService {
	@Autowired
	private BaseDAO<AttendType> typeDAO;

	public void initAttendType() {
		Properties p = Util.getPorperties("prop/attendType");

		if (p != null && !p.isEmpty()) {
			List<AttendType> types = typeDAO.find("from AttendType");
			boolean hasTypes = (types != null && !types.isEmpty());

			p.forEach((k, v) -> {
				if (hasTypes) {
					// 集合中没有定义的attendType则加入。
					if (!types.stream().anyMatch(t -> t.getName().equals(k))) {
						AttendType at = new AttendType();

						at.setName(String.valueOf(k));
						at.setAmerce(Double.valueOf(String.valueOf(v)));

						typeDAO.save(at);
					} else {
						return;
					}
				} else {
					AttendType at = new AttendType();

					at.setName(String.valueOf(k));
					at.setAmerce(Double.valueOf(String.valueOf(v)));

					typeDAO.save(at);
				}
			});
		}
	}
}
