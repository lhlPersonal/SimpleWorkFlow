package com.bufoon.service.user.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.bufoon.dao.BaseDAO;
import com.bufoon.entity.User;
import com.bufoon.service.user.UserService;

public class UserServiceImpl implements UserService {

	private BaseDAO<User> baseDAO;

	@Override
	public void saveUser(User user) {
		baseDAO.save(user);
	}

	@Override
	public void updateUser(User user) {
		baseDAO.update(user);
	}

	public BaseDAO<User> getBaseDAO() {
		return baseDAO;
	}

	public void setBaseDAO(BaseDAO<User> baseDAO) {
		this.baseDAO = baseDAO;
	}

	@Override
	public User findUserById(int id) {
		return baseDAO.get(User.class, id);
	}

	@Override
	public void deleteUser(User user) {
		baseDAO.delete(user);
	}

	@Override
	public List<User> findAllList() {
		return baseDAO.find(" from User u order by u.createTime");
	}

	@Override
	public User findUserByNameAndPassword(String username, String password) {
		return baseDAO.get(
				" from User u where u.userName = ? and u.password = ? ",
				new Object[] { username, password });
	}

}