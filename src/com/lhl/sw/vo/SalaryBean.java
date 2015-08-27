/**   
 * @author lihailong  
 * @date 2015年8月20日
 * @Description: dept salary bean for page.
 * @version 1.0   
 */
package com.lhl.sw.vo;

import java.io.Serializable;

public class SalaryBean implements Serializable {
	private String empName;
	private double amount;

	public SalaryBean() {
	}

	public SalaryBean(String empName, double amount) {
		this.empName = empName;
		this.amount = amount;
	}

	public void setEmpName(String empName) {
		this.empName = empName;
	}

	public String getEmpName() {
		return this.empName;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public double getAmount() {
		return this.amount;
	}
}