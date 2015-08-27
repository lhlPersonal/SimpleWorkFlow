/**   
 * @author lihailong
 * @date 2015-05-13
 * @Description: service for manager
 * @version 1.0   
 */
package com.lhl.sw.service.impl;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lhl.sw.dao.BaseDAO;
import com.lhl.sw.exception.HrException;
import com.lhl.sw.po.Employee;
import com.lhl.sw.po.Manager;
import com.lhl.sw.po.Payment;
import com.lhl.sw.service.MgrService;
import com.lhl.sw.util.Util;
import com.lhl.sw.vo.AppBean;
import com.lhl.sw.vo.EmpBean;
import com.lhl.sw.vo.SalaryBean;
import com.sun.org.apache.bcel.internal.generic.Select;

@Transactional
@Service
public class MgrSerivceImpl implements MgrService {

	@Autowired
	private BaseDAO<Employee> empDAO;
	@Autowired
	private BaseDAO<Payment> payDAO;

	@Override
	public void addEmp(Employee emp, int mgrId) throws HrException {
		if (emp != null && !Util.isNullOrEmpty(emp.getName())) {
			emp.setManager((Manager) empDAO.get(Employee.class, mgrId));

			empDAO.save(emp);
		}
	}

	@Override
	public List<SalaryBean> getSalaryByMgr(int mgrId) throws Exception {
		List<SalaryBean> beans = payDAO
				.find2("select new com.lhl.sw.vo.SalaryBean(p.emp.name,p.payment) from Payment as p where (p.emp.id=?0 or p.emp.manager.id=?1) and p.balanceDay=?2",
						new Object[] { mgrId, mgrId, Util.getLastMonthDay(1) });
		return beans;
	}

	@Override
	public List<EmpBean> getEmpsByMgr(int mgrId) throws HrException {
		List<EmpBean> empBeans = new ArrayList<EmpBean>();
		List<Employee> empList = empDAO.find(
				"from Employee as e where e.manager.id=?0",
				new Object[] { mgrId });

		if (!Util.isCollectionNullOrEmpty(empList)) {
			empList.parallelStream().forEach((e) -> {
				empBeans.add(getEmpBean(e));
			});
			;
		}
		return empBeans;
	}

	private EmpBean getEmpBean(Employee emp) {
		if (emp != null) {
			return new EmpBean(emp.getId(), emp.getName(), emp.getPassword(),
					emp.getSalary());
		}
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
