/**
 * @author lihailong
 * @date   2015-07-30
 * @summary Payment persist object. 
 *
 */
package com.lhl.sw.po;

import java.util.Date;

public class Payment {
	private Integer id;
	private Double payment;
	private Employee emp;
	private Date balanceDay;

	public Payment() {
	}

	public Payment(Integer id, Double payment, Employee emp, Date balanceDay) {
		super();
		this.id = id;
		this.payment = payment;
		this.emp = emp;
		this.balanceDay = balanceDay;
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

	public Date getBalanceDay() {
		return balanceDay;
	}

	public void setBalanceDay(Date balanceDay) {
		this.balanceDay = balanceDay;
	}

}
