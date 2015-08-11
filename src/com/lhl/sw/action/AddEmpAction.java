package com.lhl.sw.action;

import com.lhl.sw.action.base.MgrBaseAction;
import com.lhl.sw.po.Employee;
import com.opensymphony.xwork2.ActionContext;


public class AddEmpAction extends MgrBaseAction
{
	//������Ա����
	private Employee emp;
	//��װ��ʾ��Ϣ��tip����
	private String tip;
	//emp���Ե�setter��getter����
	public void setEmp(Employee emp)
	{
		this.emp = emp;
	}
	public Employee getEmp()
	{
		return this.emp;
	}

	//tip���Ե�setter��getter����
	public void setTip(String tip)
	{
		this.tip = tip;
	}
	public String getTip()
	{
		return this.tip;
	}

	public String execute()
		throws Exception
	{
		//����ActionContextʵ��
		ActionContext ctx = ActionContext.getContext();
		//��ȡHttpSession�е�user����
		String mgrName = (String)ctx.getSession()
			.get(WebConstant.USER);
		//������û�
		mgr.addEmp(emp , mgrName);
		setTip("����Ա���ɹ�");
		return SUCCESS;
	}

}