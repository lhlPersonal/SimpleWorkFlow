package com.lhl.sw.action;

import java.util.List;

import com.lhl.sw.action.base.EmpBaseAction;
import com.lhl.sw.util.Constant;
import com.lhl.sw.vo.PaymentBean;
import com.opensymphony.xwork2.ActionContext;


public class ViewSalaryAction extends EmpBaseAction
{
	//��װ���з�н��Ϣ��List
	private List salarys;
	//salarys���Ե�setter��getter����
	public void setSalarys(List salarys)
	{
		this.salarys = salarys;
	}
	public List getSalarys()
	{
		return this.salarys;
	}
	//�����û�����ķ���
	public String execute()
		throws Exception
	{
		//����ActionContextʵ��
		ActionContext ctx = ActionContext.getContext();
		//��ȡHttpSession�е�user����
		String user = (String)ctx.getSession()
			.get(Constant.USER);
		List<PaymentBean> salarys =  mgr.empSalary(user);
		setSalarys(salarys);
		return SUCCESS;
	}
}