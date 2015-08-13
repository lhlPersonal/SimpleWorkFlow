package com.lhl.sw.action.base;

import org.springframework.beans.factory.annotation.Autowired;

import com.lhl.sw.service.EmpService;
import com.opensymphony.xwork2.ActionSupport;

public class EmpBaseAction extends ActionSupport {
	@Autowired
	protected EmpService mgr;
}