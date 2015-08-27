/**   
 * @author lihailong
 * @date 2015-05-13
 * @Description: personal salary of some prev monthes' bean
 * @version 1.0   
 */
package com.lhl.sw.vo;

import java.io.Serializable;

public class PaymentBean implements Serializable {
	private String payMonth;
	private double amount;

	public PaymentBean() {
	}

	public PaymentBean(String payMonth, double amount) {
		this.payMonth = payMonth;
		this.amount = amount;
	}

	public void setPayMonth(String payMonth) {
		this.payMonth = payMonth;
	}

	public String getPayMonth() {
		return this.payMonth;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public double getAmount() {
		return this.amount;
	}

}