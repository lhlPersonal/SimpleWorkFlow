package com.bufoon.service.user;
 
import java.util.List;
 

import org.springframework.stereotype.Service;

import com.bufoon.entity.User;
 

public interface UserService {
 
	public void saveUser(User user);
	
	public void updateUser(User user);
	
	public User findUserById(int id);
	
	public void deleteUser(User user);
	
	public List<User> findAllList();
	
	public User findUserByNameAndPassword(String username, String password);
}