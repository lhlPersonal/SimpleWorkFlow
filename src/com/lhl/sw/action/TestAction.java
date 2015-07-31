package com.lhl.sw.action;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.lhl.sw.po.Employee;
import com.lhl.sw.po.Manager;
import com.lhl.sw.po.Payment;
import com.lhl.sw.service.EmpService;
import com.opensymphony.xwork2.ActionSupport;

@Controller
@Scope("prototype")
public class TestAction extends ActionSupport {

	@Autowired
	private EmpService empSerivceImpl;

	@Override
	public String execute() throws Exception {
		Payment payment = new Payment();
		payment.setMonth(1);
		payment.setPayment(5000d);

		Employee employee = new Employee();
		employee.setName("111");
		employee.setPassword("22");
		employee.setSalary(5400d);

		Manager nanager = new Manager();
		nanager.setDept("rd");

		employee.setManager(nanager);

		payment.setEmp(employee);

		empSerivceImpl.savePayment(payment);

		return super.execute();
	}

}
