/**   
 * @author lihailong
 * @date 2015-05-13
 * @Description: valid punch action. 
 *               come time:before 9:30 am,leave time:after 6:00 pm.
 * @version 1.0   
 */
package com.lhl.sw.action;

import java.text.SimpleDateFormat;
import java.time.Instant;
import java.util.Calendar;
import java.util.Date;

import com.lhl.sw.action.base.EmpBaseAction;
import com.lhl.sw.util.Constant;
import com.lhl.sw.util.Util;
import com.opensymphony.xwork2.ActionContext;

public class PunchAction extends EmpBaseAction {
	// 可上班打卡
	private boolean comeValid;
	// 可下班打卡
	private boolean leaveValid;

	public boolean isComeValid() {
		return comeValid;
	}

	public void setComeValid(boolean comeValid) {
		this.comeValid = comeValid;
	}

	public boolean isLeaveValid() {
		return leaveValid;
	}

	public void setLeaveValid(boolean leaveValid) {
		this.leaveValid = leaveValid;
	}

	public String execute() throws Exception {
		Date date = Date.from(Instant.now());
		int userid = Util.getUserId();
		int result = mgr.validPunch(userid, Date.from(Instant.now()));

		setComeValid(result == mgr.COME_PUNCH);
		setLeaveValid(result == mgr.LEAVE_PUNCH);

		return SUCCESS;
	}
}