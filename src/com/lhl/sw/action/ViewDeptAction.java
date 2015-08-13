package com.lhl.sw.action;

import java.util.List;

import com.lhl.sw.action.base.MgrBaseAction;
import com.lhl.sw.util.Constant;
import com.lhl.sw.vo.SalaryBean;
import com.opensymphony.xwork2.ActionContext;


public class ViewDeptAction extends MgrBaseAction
{
	//��װ��н�б��List����
	private List sals;
	//sals���Ե�setter��getter����
	public void setSals(List sals)
	{
		this.sals = sals;
	}
	public List getSals()
	{
		return this.sals;
	}	

	public String execute()
		throws Exception
	{
		//����ActionContextʵ��
		ActionContext ctx = ActionContext.getContext();
		//��ȡHttpSession�е�user����
		String mgrName = (String)ctx.getSession()
			.get(Constant.USER);
		//����ҵ���߼�����ȡ�õ�ǰԱ����ȫ����н�б�
		List<SalaryBean> result = mgr.getSalaryByMgr(mgrName);
		System.out.println("--------------" + result);
		setSals(result);
		return SUCCESS;
	}
}