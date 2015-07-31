package com.lhl.sw.test;

import java.util.Arrays;
import java.util.HashSet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.lhl.sw.dao.BaseDAO;
import com.lhl.sw.dao.impl.BaseDAOImpl;
import com.lhl.sw.po.Application;
import com.lhl.sw.po.Employee;
import com.lhl.sw.po.Manager;
import com.lhl.sw.po.Payment;
import com.lhl.sw.service.EmpService;
import com.lhl.sw.service.impl.EmpSerivceImpl;

public class Test {
	public static void main(String[] args) {
		ApplicationContext act = new ClassPathXmlApplicationContext(
				"spring.xml");
		EmpService empService = act.getBean(EmpService.class);

		Payment payment = new Payment();
		payment.setMonth(1);
		payment.setPayment(5000d);

		Employee employee = new Employee();
		employee.setName("111");
		employee.setPassword("22");
		employee.setSalary(5400d);

		Manager nanager = new Manager();
		
		nanager.setName("manager1");
		nanager.setPassword("33333");
		nanager.setDept("rd");
		nanager.setSalary(8000d);
		nanager.setPayments(null);

		employee.setManager(nanager);

		empService.saveEmp(nanager);
		empService.saveEmp(employee);
		
		payment.setEmp(employee);
		
		empService.savePayment(payment);
	}
}
