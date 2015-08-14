package com.lhl.sw.action.authority;

import com.opensymphony.xwork2.*;
import com.opensymphony.xwork2.interceptor.*;
import com.lhl.sw.util.Constant;

public class MgrAuthorityInterceptor extends AbstractInterceptor {
	public String intercept(ActionInvocation invocation) throws Exception {

		return invocation.invoke();

	}
}