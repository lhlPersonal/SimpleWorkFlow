/**   
 * @author lihailong
 * @date 2015-05-13
 * @Description: add employee action
 * @version 1.0   
 */
package com.lhl.sw.action;

import com.lhl.sw.action.base.MgrBaseAction;
import com.lhl.sw.po.Employee;
import com.lhl.sw.util.Constant;
import com.lhl.sw.util.Util;
import com.opensymphony.xwork2.ActionContext;

public class AddEmpAction extends MgrBaseAction {
	private Employee emp;

	public void setEmp(Employee emp) {
		this.emp = emp;
	}

	public Employee getEmp() {
		return this.emp;
	}

	public String execute() throws Exception {
		mgr.addEmp(emp, Util.getUserId());
		return SUCCESS;
	}
}