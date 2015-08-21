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
		return super.execute();
	}

}
