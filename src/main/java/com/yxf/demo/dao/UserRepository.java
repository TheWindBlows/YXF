package com.yxf.demo.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.yxf.demo.mode.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, String>{
	
	public User findByUserName(String userName);

}
