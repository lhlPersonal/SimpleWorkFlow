/**   
 * @author lihailong
 * @date 2015-05-13
 * @Description: punch action. 
 *               
 * @version 1.0   
 */
package com.lhl.sw.action;

import com.lhl.sw.action.base.EmpBaseAction;
import com.lhl.sw.util.Constant;
import com.lhl.sw.util.Util;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class ProcessPunchAction extends EmpBaseAction {

	public String come() throws Exception {
		return process(true);
	}

	public String leave() throws Exception {
		return process(false);
	}

	private String process(boolean isCome) throws Exception {
		mgr.punch(Util.getUserId(), isCome);

		return SUCCESS;
	}
}