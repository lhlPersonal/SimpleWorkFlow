/**
 * @author lihailong
 * @date   2015-07-30
 * @summary employee persist object. 
 *
 */
package com.lhl.sw.po;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

public class Employee implements Serializable {
	private Integer id;
	private String name;
	private String password;
	private Double salary;
	private Manager manager;
	private Set<Attend> attends = new HashSet<Attend>();
	private Set<Payment> payments = new HashSet<Payment>();

	public Employee() {

	}

	public Employee(Integer id, String name, String password, Double salary,
			Manager manager, Set<Attend> attends, Set<Payment> payments) {
		super();
		this.id = id;
		this.name = name;
		this.password = password;
		this.salary = salary;
		this.manager = manager;
		this.attends = attends;
		this.payments = payments;
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

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Double getSalary() {
		return salary;
	}

	public void setSalary(Double salary) {
		this.salary = salary;
	}

	public Manager getManager() {
		return manager;
	}

	public void setManager(Manager manager) {
		this.manager = manager;
	}

	public Set<Attend> getAttends() {
		return attends;
	}

	public void setAttends(Set<Attend> attends) {
		this.attends = attends;
	}

	public Set<Payment> getPayments() {
		return payments;
	}

	public void setPayments(Set<Payment> payments) {
		this.payments = payments;
	}
}
