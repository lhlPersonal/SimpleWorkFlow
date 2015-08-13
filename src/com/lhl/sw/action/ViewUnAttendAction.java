package com.lhl.sw.action;

import java.util.List;

import com.lhl.sw.action.base.EmpBaseAction;
import com.lhl.sw.util.Constant;
import com.lhl.sw.vo.AttendBean;
import com.opensymphony.xwork2.ActionContext;

public class ViewUnAttendAction extends EmpBaseAction
{
	private List<AttendBean> unAttend;
	//unAttend���Ե�setter��getter����
	public void setUnAttend(List<AttendBean> unAttend)
	{
		this.unAttend = unAttend;
	}
	public List<AttendBean> getUnAttend()
	{
		return this.unAttend;
	}
	public String execute()
		throws Exception
	{
		//����ActionContextʵ��
		ActionContext ctx = ActionContext.getContext();
		//��ȡHttpSession�е�user����
		String user = (String)ctx.getSession()
			.get(Constant.USER);
		List<AttendBean> result = mgr.unAttend(user);
		setUnAttend(result);
		return SUCCESS;
	}
}