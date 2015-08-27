/**   
 * @author lihailong
 * @date 2015-05-13
 * @Description: show dept salary action
 * @version 1.0   
 */

package com.lhl.sw.action;

import java.util.List;

import com.lhl.sw.action.base.MgrBaseAction;
import com.lhl.sw.util.Constant;
import com.lhl.sw.util.Util;
import com.lhl.sw.vo.SalaryBean;
import com.opensymphony.xwork2.ActionContext;

public class ViewDeptAction extends MgrBaseAction {

	private List<SalaryBean> sals;

	public void setSals(List<SalaryBean> sals) {
		this.sals = sals;
	}

	public List<SalaryBean> getSals() {
		return this.sals;
	}

	public String execute() throws Exception {
		List<SalaryBean> result = mgr.getSalaryByMgr(Util.getUserId());
		setSals(result);

		return SUCCESS;
	}
}