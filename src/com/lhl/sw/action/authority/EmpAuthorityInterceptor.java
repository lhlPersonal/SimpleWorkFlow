package com.lhl.sw.action.authority;

import com.opensymphony.xwork2.*;
import com.opensymphony.xwork2.interceptor.*;
import com.lhl.sw.util.Constant;

public class EmpAuthorityInterceptor
	extends AbstractInterceptor
{
	public String intercept(ActionInvocation invocation) 
		throws Exception
	{
		//����ActionContextʵ��
		ActionContext ctx = ActionContext.getContext();
		//��ȡHttpSession�е�level����
		String level = (String)ctx.getSession()
			.get(Constant.LEVEL);
		//���level��Ϊnull����levelΪemp��mgr
		if (level != null 
			&& (level.equals(Constant.EMP_LEVEL) 
			|| level.equals(Constant.MGR_LEVEL)))
		{
			return invocation.invoke();
		}
		else
		{
			return Action.LOGIN;
		}
	}
}