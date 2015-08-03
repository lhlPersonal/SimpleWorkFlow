package com.lhl.sw.service.impl;

import java.util.Set;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import antlr.collections.List;

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
		emp.setSalary(6700d);
		empDao.update(emp);
	}

	public Set<Payment> getPaymentsByEmpId(Integer empId) {
		Set<Payment> pays = empDao.get(Employee.class, empId).getPayments();
		System.out.println(pays.size());
		return pays;
	}

	@Override
	public Employee getEmpById(Integer empId) {
		return empDao.get(Employee.class, empId);
	}
}
