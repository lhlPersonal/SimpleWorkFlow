package com.lhl.sw.test;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

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
				"spring_jpa.xml");
		EmpService empService = act.getBean(EmpService.class);

		// /* Payment payment = new Payment();
		// payment.setMonth(1);
		// payment.setPayment(5000d);
		//
		// Payment payment1 = new Payment();
		// payment1.setMonth(2);
		// payment1.setPayment(6000d);
		//
		// Payment payment2 = new Payment();
		// payment2.setMonth(3);
		// payment2.setPayment(7000d);
		//
		Employee employee = new Employee();
		employee.setName("ffffff");
		employee.setPassword("4444");
		employee.setSalary(5990d);

		employee.setManager((Manager) empService.getEmpById(13));
		//
		// empService.saveEmp(nanager);
		// // 双向1-n时，由n方维护关联关系。先持久化外键对应的类，然后设置外键实例，保证插入的时候外键有值。
		empService.saveEmp(employee);
		//
		// payment.setEmp(employee);
		// payment1.setEmp(employee);
		// payment2.setEmp(employee);
		//
		// empService.savePayment(payment);
		// empService.savePayment(payment1);
		// empService.savePayment(payment2);*/

		// Set<Payment> pays = empService.getEmpById(14);
		// System.out.println(pays);
	}
}
