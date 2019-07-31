package com.yxf.demo.service;

import java.util.List;

import com.yxf.demo.mode.entity.User;
import com.yxf.demo.mode.from.UserSaveFrom;

public interface UserService {
	
	public void saveUser(UserSaveFrom userForm);
	
	public List<User> findUser();
	
	public User findUserRedis(String userName);
}
