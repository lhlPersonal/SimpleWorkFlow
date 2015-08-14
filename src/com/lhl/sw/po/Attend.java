/**
 * @author lihailong
 * @date   2015-07-30
 * @summary Attend persist object. 
 *
 */
package com.lhl.sw.po;

import java.sql.Date;
import java.sql.Time;

public class Attend {

	private Integer id;
	// 考勤日期
	private Date date;

	// 上班时间
	private Time comeTime;
	// 下班时间
	private Time leaveTime;
	private AttendType attendType;
	private Employee employee;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public Time getComeTime() {
		return comeTime;
	}

	public void setComeTime(Time comeTime) {
		this.comeTime = comeTime;
	}

	public Time getLeaveTime() {
		return leaveTime;
	}

	public void setLeaveTime(Time leaveTime) {
		this.leaveTime = leaveTime;
	}

	public AttendType getAttendType() {
		return attendType;
	}

	public void setAttendType(AttendType attendType) {
		this.attendType = attendType;
	}

	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}
}
