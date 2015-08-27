package com.lhl.sw.test;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.lhl.sw.po.Application;
import com.lhl.sw.service.MgrService;
import com.lhl.sw.vo.SalaryBean;

public class Test {
	public static void main(String[] args) {
		ApplicationContext act = new ClassPathXmlApplicationContext(
				"jpa/spring_jpa.xml");
		try {
			List<SalaryBean> salaryBeans = act.getBean(MgrService.class)
					.getSalaryByMgr(1);

			salaryBeans.forEach((s) -> {
				System.out.println(s.getEmpName() + "  " + s.getAmount());

			});
		} catch (BeansException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
