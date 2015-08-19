package com.lhl.sw.service;

import java.util.List;
import java.util.Properties;

import javax.transaction.Transactional;

import org.apache.velocity.runtime.directive.Break;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lhl.sw.dao.BaseDAO;
import com.lhl.sw.po.AttendType;
import com.lhl.sw.util.Util;

public interface DataInitService {
	/**
	 * 初始化attend type数据
	 */
	void initAttendType();
}
