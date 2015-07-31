/**
 * @author lihailong
 * @date   2015-07-30
 * @summary Attend persist object. 
 *
 */
package com.lhl.sw.po;

import java.sql.Timestamp;
import java.time.Instant;

public class Attend {

	private Integer id;
	private Timestamp attendTime;
	private AttendType attendType;
	private Employee employee;

	public Attend() {
		super();
	}

	public Attend(Integer id, Timestamp attendTime, AttendType attendType,
			Employee employee) {
		super();
		this.id = id;
		this.attendTime = attendTime;
		this.attendType = attendType;
		this.employee = employee;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Timestamp getAttendTime() {
		return attendTime;
	}

	public void setAttendTime(Timestamp attendTime) {
		this.attendTime = attendTime;
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
