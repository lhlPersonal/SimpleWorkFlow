/**   
 * @author lihailong
 * @date 2015-05-13
 * @Description: show personal salary of some prev monthes.
 * @version 1.0   
 */
package com.lhl.sw.action;

import java.util.List;

import com.lhl.sw.action.base.EmpBaseAction;
import com.lhl.sw.util.Constant;
import com.lhl.sw.util.Util;
import com.lhl.sw.vo.PaymentBean;
import com.opensymphony.xwork2.ActionContext;

public class ViewSalaryAction extends EmpBaseAction {
	private List<PaymentBean> salarys;

	public void setSalarys(List<PaymentBean> salarys) {
		this.salarys = salarys;
	}

	public List<PaymentBean> getSalarys() {
		return this.salarys;
	}

	public String execute() throws Exception {

		List<PaymentBean> salarys = mgr.empSalary(Util.getUserId(), 5);
		setSalarys(salarys);
		return SUCCESS;
	}
}