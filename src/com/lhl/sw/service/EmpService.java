package com.lhl.sw.service;

import java.util.Set;

import com.lhl.sw.po.Employee;
import com.lhl.sw.po.Payment;

public interface EmpService {
	void savePayment(Payment pay);

	void saveEmp(Employee emp);

	Set<Payment> getPaymentsByEmpId(Integer empId);

	Employee getEmpById(Integer empId);
}
