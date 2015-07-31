/**
 * @author lihailong
 * @date   2015-07-30
 * @summary AttendType persist object. 
 *
 */
package com.lhl.sw.po;

public class AttendType {
	// 标识属性
	private Integer id;
	// 出勤类型的名称
	private String name;
	// 此类出勤对应的罚款
	private double amerce;

	public AttendType() {

	}

	public AttendType(Integer id, String name, double amerce) {
		super();
		this.id = id;
		this.name = name;
		this.amerce = amerce;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getAmerce() {
		return amerce;
	}

	public void setAmerce(double amerce) {
		this.amerce = amerce;
	}

}
