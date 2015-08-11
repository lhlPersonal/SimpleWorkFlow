package com.lhl.sw.action;

import java.util.List;

import com.lhl.sw.action.base.MgrBaseAction;
import com.opensymphony.xwork2.ActionContext;


public class ViewAppAction extends MgrBaseAction
{
	private List apps;
	//apps���Ե�setter��getter����
	public void setApps(List apps)
	{
		this.apps = apps;
	}
	public List getApps()
	{
		return this.apps;
	}
	public String execute()
		throws Exception
	{
		//����ActionContextʵ��
		ActionContext ctx = ActionContext.getContext();
		//��ȡHttpSession�е�user����
		String mgrName = (String)ctx.getSession()
			.get(WebConstant.USER);
		//��ȡ��Ҫ����ǰ���?���ȫ������
		setApps(mgr.getAppsByMgr(mgrName));
		return SUCCESS;
	}
}