/**
 * @author lihailong
 * @date   2015-07-30
 * @summary manage all employees in manager's department. 
 *
 */
package com.lhl.sw.po;

import java.time.Instant;
import java.util.HashSet;
import java.util.Set;

public class Manager extends Employee {

	private String dept;
	private Set<Employee> employees = new HashSet<Employee>();
	private Set<CheckBack> backs = new HashSet<CheckBack>();

	public Manager() {
		super();
	}

	public Manager(String dept, Set<Employee> employees, Set<CheckBack> backs) {
		super();
		this.dept = dept;
		this.employees = employees;
		this.backs = backs;
	}

	public String getDept() {
		return dept;
	}

	public void setDept(String dept) {
		this.dept = dept;
	}

	public Set<Employee> getEmployees() {
		return employees;
	}

	public void setEmployees(Set<Employee> employees) {
		this.employees = employees;
	}

	public Set<CheckBack> getBacks() {
		return backs;
	}

	public void setBacks(Set<CheckBack> backs) {
		this.backs = backs;
	}

}
