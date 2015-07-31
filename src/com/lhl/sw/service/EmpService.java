package com.lhl.sw.service;

import com.lhl.sw.po.Employee;
import com.lhl.sw.po.Payment;

public interface EmpService {
	void savePayment(Payment pay);
	void saveEmp(Employee emp);
}
