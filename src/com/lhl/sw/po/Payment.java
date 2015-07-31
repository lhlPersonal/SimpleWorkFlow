/**
 * @author lihailong
 * @date   2015-07-30
 * @summary Payment persist object. 
 *
 */
package com.lhl.sw.po;

public class Payment {
	private Integer id;
	private Double payment;
	private Employee emp;
	private int month;

	public Payment() {
	}

	public Payment(Integer id, Double payment, Employee emp, int month) {
		super();
		this.id = id;
		this.payment = payment;
		this.emp = emp;
		this.month = month;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Double getPayment() {
		return payment;
	}

	public void setPayment(Double payment) {
		this.payment = payment;
	}

	public Employee getEmp() {
		return emp;
	}

	public void setEmp(Employee emp) {
		this.emp = emp;
	}

	public int getMonth() {
		return month;
	}

	public void setMonth(int month) {
		this.month = month;
	}

}
