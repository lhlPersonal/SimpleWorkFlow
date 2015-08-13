/**   
 * @author lihailong
 * @date 2015-05-13
 * @Description: service for employee
 * @version 1.0   
 */
package com.lhl.sw.service.impl;

import java.util.Set;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import antlr.collections.List;

import com.lhl.sw.dao.BaseDAO;
import com.lhl.sw.po.AttendType;
import com.lhl.sw.po.Employee;
import com.lhl.sw.po.Manager;
import com.lhl.sw.po.Payment;
import com.lhl.sw.service.EmpService;
import com.lhl.sw.vo.AttendBean;
import com.lhl.sw.vo.PaymentBean;

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

	@Override
	public int validLogin(Manager mgr) {
		if (mgr != null) {
			// 问号传递参数时必须从0开始，且为连续值才行，用别名则不必指定数字。
			Employee emp = empDao
					.get("select e from Employee as e where e.name=?0 and e.password=?1",
							new Object[] { mgr.getName(), mgr.getPassword() });

			if (emp != null) {
				if (emp.getManager() != null) {
					return LOGIN_EMP;
				} else {
					return LOGIN_MGR;
				}
			}
		}
		return LOGIN_FAIL;
	}

	@Override
	public void autoPunch() {
		// TODO Auto-generated method stub

	}

	@Override
	public void autoPay() {
		// TODO Auto-generated method stub

	}

	@Override
	public int validPunch(String user, String dutyDay) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int punch(String user, String dutyDay, boolean isCome) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public java.util.List<PaymentBean> empSalary(String empName) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public java.util.List<AttendBean> unAttend(String empName) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public java.util.List<AttendType> getAllType() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean addApplication(int attId, int typeId, String reason) {
		// TODO Auto-generated method stub
		return false;
	}
}
