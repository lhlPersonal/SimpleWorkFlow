package com.lhl.sw.service.impl;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lhl.sw.dao.BaseDAO;
import com.lhl.sw.po.Employee;
import com.lhl.sw.po.Manager;
import com.lhl.sw.po.Payment;
import com.lhl.sw.service.EmpService;

@Service
@Transactional
public class EmpSerivceImpl implements EmpService {

	@Autowired
	private BaseDAO<Payment> payDao;
	@Autowired
	private BaseDAO<Employee> empDao;

	public void savePayment(Payment pay) {
		payDao.save(pay);
	}

	@Override
	public void saveEmp(Employee emp) {
		empDao.save(emp);
	}
}
