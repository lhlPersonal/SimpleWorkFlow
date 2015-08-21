package com.lhl.sw.action;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class LogoutAction extends ActionSupport {

	public String execute() throws Exception {
		ActionContext.getContext().getSession().clear();

		return SUCCESS;
	}
}