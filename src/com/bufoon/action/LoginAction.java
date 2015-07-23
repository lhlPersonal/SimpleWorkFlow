package com.bufoon.action;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.bufoon.entity.User;
import com.bufoon.service.user.UserService;
import com.opensymphony.xwork2.ActionSupport;

@Controller
@Scope("prototype")
public class LoginAction extends ActionSupport {

	private static final long serialVersionUID = 1L;

	@Autowired
	private UserService userService;

	private String username;
	private String password;

	@Override
	public String execute() throws Exception {
		HttpServletRequest request = ServletActionContext.getRequest();
		User user = userService.findUserByNameAndPassword(username, password);
		if (user == null) {
			user = new User();
			user.setUserName(username);
			user.setPassword(password);
			userService.saveUser(user);
		}

		request.setAttribute("username", username);
		return SUCCESS;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}