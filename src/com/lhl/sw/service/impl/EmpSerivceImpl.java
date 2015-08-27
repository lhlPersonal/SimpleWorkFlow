/**   
 * @author lihailong
 * @date 2015-05-13
 * @Description: service for employee
 * @version 1.0   
 */
package com.lhl.sw.service.impl;

import java.sql.Time;
import java.text.DateFormat;
import java.text.MessageFormat;
import java.text.SimpleDateFormat;
import java.time.Clock;
import java.time.Instant;
import java.time.LocalTime;
import java.time.OffsetDateTime;
import java.time.ZoneOffset;
import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Properties;
import java.util.Set;

import javafx.scene.input.DataFormat;

import javax.annotation.PostConstruct;
import javax.swing.text.html.ObjectView;
import javax.transaction.Transactional;

import org.quartz.ListenerManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.DependsOn;
import org.springframework.stereotype.Service;

import com.lhl.sw.dao.BaseDAO;
import com.lhl.sw.po.Attend;
import com.lhl.sw.po.AttendType;
import com.lhl.sw.po.Employee;
import com.lhl.sw.po.Manager;
import com.lhl.sw.po.Payment;
import com.lhl.sw.service.EmpService;
import com.lhl.sw.util.Util;
import com.lhl.sw.vo.AttendBean;
import com.lhl.sw.vo.PaymentBean;

@Service
@Transactional
public class EmpSerivceImpl implements EmpService {

	@Autowired
	private BaseDAO<Payment> payDao;
	@Autowired
	private BaseDAO<Employee> empDao;

	@Autowired
	private BaseDAO<Attend> attDao;
	@Autowired
	private BaseDAO<AttendType> typeDao;

	@Override
	public Employee getEmpById(Integer empId) {
		return empDao.get(Employee.class, empId);
	}

	@Override
	public int[] validLogin(Manager mgr) {
		if (mgr != null) {
			// 问号传递参数时必须从0开始，且为连续值才行，用别名则不必指定数字。
			Employee emp = empDao
					.get("select e from Employee as e where e.name=?0 and e.password=?1",
							new Object[] { mgr.getName(), mgr.getPassword() });

			if (emp != null) {
				if (emp.getManager() != null) {
					return new int[] { LOGIN_EMP, emp.getId() };
				} else {
					return new int[] { LOGIN_MGR, emp.getId() };
				}
			}
		}
		return new int[] { LOGIN_FAIL };
	}

	@Override
	public void autoPunch() {
		this.callProcedure("attendProc(?0)",
				new Object[] { Date.from(Instant.now()) });
	}

	@Override
	public void autoPay() {
		this.callProcedure("balanceMonthSalary()", null);
	}

	/**
	 * 1.时间是否在打卡时间范围内。2.是否已经打了卡。3.上午没打而下午也可以打。 上午：可打卡的条件，数据库中没有今天的出勤记录。
	 * 下午：下午没有打过卡。
	 */
	@Override
	public int validPunch(int userId, Date dutyDay) {
		// 上午9:30之前可上班打卡
		ZonedDateTime date = ZonedDateTime.now();

		if (date.getHour() < 10 && date.getMinute() <= 30) {
			Attend attend = attDao
					.get("select a from Attend a where a.employee.id=?0 and a.date=?1",
							new Object[] { userId, dutyDay });

			if (attend == null) {
				return COME_PUNCH;
			}
		} // 下午18:00后可下班打卡
		else if (date.getHour() >= 18) {
			Attend attend = attDao
					.get("select a from Attend a where a.employee.id=?0 and a.date=?1",
							new Object[] { userId, dutyDay });

			// 下午没有打卡或者上午没有打卡 在下班时间后都可以打卡
			if ((attend != null && attend.getLeaveTime() == null)
					|| attend == null) {
				return LEAVE_PUNCH;
			}
		}

		return NO_PUNCH;
	}

	@Override
	public void punch(int userId, boolean isCome) {
		if (isCome) {
			Attend attend = new Attend();
			// attend 日期
			attend.setDate(Date.from(Instant.now()));
			// 上班打卡时间
			attend.setComeTime(Time.valueOf(LocalTime.now()));
			// 打卡的人
			attend.setEmployee(empDao.get(Employee.class, userId));

			attDao.save(attend);
		} else {
			Attend attend = attDao
					.get("select a from Attend a where a.date=?0 and a.employee.id=?1",
							new Object[] { Date.from(Instant.now()), userId });
			// 上班打卡了下班没打
			if (attend != null) {
				// 记录下班打卡时间
				attend.setLeaveTime(Time.valueOf(LocalTime.now()));

				attDao.update(attend);
			} else {
				// 上班没打卡，则只对下班进行打卡
				attend = new Attend();
				// attend 日期
				attend.setDate(Date.from(Instant.now()));
				// 下班打卡时间
				attend.setLeaveTime(Time.valueOf(LocalTime.now()));
				// 打卡的人
				attend.setEmployee(empDao.get(Employee.class, userId));

				attDao.save(attend);
			}
		}
	}

	@Override
	public java.util.List<PaymentBean> empSalary(int empId, int totalMonth) {
		List<Payment> payments = payDao
				.find("select p from Payment as p where p.emp.id=?0 and p.balanceDay>=?1",
						new Object[] { empId, Util.getLastMonthDay(totalMonth) });
		List<PaymentBean> beans = new ArrayList<PaymentBean>();

		DateFormat df = new SimpleDateFormat("yyyy-MM-dd");

		if (!Util.isCollectionNullOrEmpty(payments)) {
			payments.forEach((p) -> {
				beans.add(new PaymentBean(df.format(p.getBalanceDay()), p
						.getPayment()));
			});
		}
		return beans;
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

	@Override
	public int callProcedure(String procName, Object[] params) {
		return empDao.callProcedure(procName, params);
	}
}
