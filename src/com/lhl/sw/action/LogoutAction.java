package com.lhl.sw.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.opensymphony.xwork2.*;
import org.apache.struts2.interceptor.*;

public class LogoutAction extends ActionSupport
	implements ServletRequestAware
{
	//����һ��HttpServletRequest����
	private HttpServletRequest request;
	//ʵ��ServletRequestAware�ӿڱ�����д�ķ���
	public void setServletRequest(
		HttpServletRequest request)
	{
		this.request = request;
	}
	public String execute()
		throws Exception
	{
		//��ȡHttpSession
		HttpSession session = request.getSession();
		//ʹSessionʧЧ
		session.invalidate();
		return SUCCESS;
	}
}