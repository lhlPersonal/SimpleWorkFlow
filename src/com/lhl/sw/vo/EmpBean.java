/**   
 * @author lihailong
 * @date 2015-05-13
 * @Description: employee bean
 * @version 1.0   
 */
package com.lhl.sw.vo;

import java.io.Serializable;

public class EmpBean implements Serializable {
	private int empId;
	private String empName;
	private String empPass;
	private double amount;

	public EmpBean(int empId, String empName, String empPass, double amount) {
		this.empName = empName;
		this.empPass = empPass;
		this.amount = amount;
		this.empId = empId;
	}

	public int getEmpId() {
		return empId;
	}

	public void setEmpId(int empId) {
		this.empId = empId;
	}

	public void setEmpName(String empName) {
		this.empName = empName;
	}

	public String getEmpName() {
		return this.empName;
	}

	public void setEmpPass(String empPass) {
		this.empPass = empPass;
	}

	public String getEmpPass() {
		return this.empPass;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public double getAmount() {
		return this.amount;
	}
}