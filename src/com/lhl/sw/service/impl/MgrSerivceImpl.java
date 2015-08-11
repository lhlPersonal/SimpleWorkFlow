package com.lhl.sw.service.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.lhl.sw.exception.HrException;
import com.lhl.sw.po.Employee;
import com.lhl.sw.service.MgrService;
import com.lhl.sw.vo.AppBean;
import com.lhl.sw.vo.EmpBean;
import com.lhl.sw.vo.SalaryBean;

@Transactional
@Service
public class MgrSerivceImpl implements MgrService {

	@Override
	public void addEmp(Employee emp, String mgr) throws HrException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<SalaryBean> getSalaryByMgr(String mgr) throws HrException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<EmpBean> getEmpsByMgr(String mgr) throws HrException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<AppBean> getAppsByMgr(String mgr) throws HrException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void check(int appid, String mgrName, boolean result) {
		// TODO Auto-generated method stub
		
	}

}
