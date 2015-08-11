package com.lhl.sw.action.base;

import org.springframework.beans.factory.annotation.Autowired;

import com.lhl.sw.service.MgrService;
import com.opensymphony.xwork2.ActionSupport;


public class MgrBaseAction extends ActionSupport {
	@Autowired
	protected MgrService mgr;

	public MgrService getMgr() {
		return mgr;
	}

	public void setMgr(MgrService mgr) {
		this.mgr = mgr;
	}

}