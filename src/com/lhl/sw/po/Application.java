/**
 * @author lihailong
 * @date   2015-07-30
 * @summary Application persist object. 
 *
 */
package com.lhl.sw.po;

import java.io.Serializable;
import java.sql.Timestamp;

import sun.misc.SignalHandler;

public class Application implements Serializable {
	private Integer id;
	private CheckBack checkBack;
	private Timestamp appTime;
	// 关联的出勤
	private Attend attend;
	// 希望将指定出勤改为的type类型
	private AttendType attendType;

	private String reason;

	public Application() {

	}

	public Application(Integer id, Timestamp timestamp, AttendType attendType,
			String reason) {
		super();
		this.id = id;
		this.appTime = timestamp;
		this.attendType = attendType;
		this.reason = reason;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public CheckBack getCheckBack() {
		return checkBack;
	}

	public void setCheckBack(CheckBack checkBack) {
		this.checkBack = checkBack;
	}

	public Attend getAttend() {
		return attend;
	}

	public void setAttend(Attend attend) {
		this.attend = attend;
	}

	public Timestamp getAppTime() {
		return appTime;
	}

	public void setAppTime(Timestamp appTime) {
		this.appTime = appTime;
	}

	public AttendType getAttendType() {
		return attendType;
	}

	public void setAttendType(AttendType attendType) {
		this.attendType = attendType;
	}

	public String getReason() {
		return reason;
	}

	public void setReason(String reason) {
		this.reason = reason;
	}

}
