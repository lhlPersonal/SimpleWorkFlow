package com.lhl.sw.action;

import java.util.List;

import com.lhl.sw.action.base.MgrBaseAction;
import com.lhl.sw.util.Constant;
import com.opensymphony.xwork2.ActionContext;

public class ViewEmpAction extends MgrBaseAction
{
	//��װ��ǰ��������Ա����List
	private List emps;
	//emps���Ե�setter��getter����
	public void setEmps(List emps)
	{
		this.emps = emps;
	}
	public List getEmps()
	{
		return this.emps;
	}
	public String execute()
		throws Exception
	{
		//����ActionContextʵ��
		ActionContext ctx = ActionContext.getContext();
		//��ȡHttpSession�е�user����
		String mgrName = (String)ctx.getSession()
			.get(Constant.USER);
		setEmps(mgr.getEmpsByMgr(mgrName));
		return SUCCESS;
	}
}