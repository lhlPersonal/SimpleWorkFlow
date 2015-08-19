/**   
 * @author lihailong
 * @date 2015-05-13
 * @Description: view employee list action
 * @version 1.0   
 */
package com.lhl.sw.action;

import java.util.List;

import com.lhl.sw.action.base.MgrBaseAction;
import com.lhl.sw.po.Employee;
import com.lhl.sw.util.Constant;
import com.lhl.sw.util.Util;
import com.lhl.sw.vo.EmpBean;
import com.opensymphony.xwork2.ActionContext;

public class ViewEmpAction extends MgrBaseAction {
	private List<EmpBean> emps;

	public List<EmpBean> getEmps() {
		return emps;
	}

	public void setEmps(List<EmpBean> emps) {
		this.emps = emps;
	}

	public String execute() throws Exception {
		setEmps(mgr.getEmpsByMgr(Util.getUserId()));
		return SUCCESS;
	}
}