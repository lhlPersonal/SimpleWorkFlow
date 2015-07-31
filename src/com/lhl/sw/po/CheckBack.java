/**
 * @author lihailong
 * @date   2015-07-30
 * @summary CheckBack persist object. 
 *
 */
package com.lhl.sw.po;

public class CheckBack {
	private Integer id;
	private Application app;
	private Manager manager;
	private Boolean allow;

	public CheckBack() {
	};

	public CheckBack(Integer id, Application app, Manager manager, Boolean allow) {
		super();
		this.id = id;
		this.app = app;
		this.manager = manager;
		this.allow = allow;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Application getApp() {
		return app;
	}

	public void setApp(Application app) {
		this.app = app;
	}

	public Manager getManager() {
		return manager;
	}

	public void setManager(Manager manager) {
		this.manager = manager;
	}

	public Boolean getAllow() {
		return allow;
	}

	public void setAllow(Boolean allow) {
		this.allow = allow;
	}
}
