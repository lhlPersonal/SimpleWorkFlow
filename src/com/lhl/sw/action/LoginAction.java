/**   
 * @author lihailong
 * @date 2015-05-13
 * @Description: login action
 * @version 1.0   
 */
package com.lhl.sw.action;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Optional;

import com.lhl.sw.action.base.EmpBaseAction;
import com.lhl.sw.po.Manager;
import com.lhl.sw.util.Constant;
import com.lhl.sw.util.Util;
import com.opensymphony.xwork2.ActionContext;

public class LoginAction extends EmpBaseAction {
	private final String EMP_RESULT = "emp";
	private final String MGR_RESULT = "mgr";
	private Manager manager;
	private String vercode;
	private String tip;

	public void setManager(Manager manager) {
		this.manager = manager;
	}

	public Manager getManager() {
		return this.manager;
	}

	public void setVercode(String vercode) {
		this.vercode = vercode;
	}

	public String getVercode() {
		return this.vercode;
	}

	public void setTip(String tip) {
		this.tip = tip;
	}

	public String getTip() {
		return this.tip;
	}

	public String execute() {
		// 获取验证码
		String authCode = String.valueOf(ActionContext.getContext()
				.getSession().get(Constant.AUTH_CODE));

		if (!Util.isNullOrEmpty(authCode)) {
			// 验证码正确
			if (authCode.equalsIgnoreCase(vercode)) {
				int[] result = mgr.validLogin(manager);

				if (result != null && result.length > 0
						&& result[0] != mgr.LOGIN_FAIL) {
					ActionContext.getContext().getSession()
							.put(Constant.USER, manager.getName());
					ActionContext.getContext().getSession()
							.put(Constant.USER_ID, result[1]);

					if (result[0] == mgr.LOGIN_EMP) {
						return EMP_RESULT;
					} else if (result[0] == mgr.LOGIN_MGR) {
						return MGR_RESULT;
					}
				}
			}
		}
		return ERROR;
	}
}