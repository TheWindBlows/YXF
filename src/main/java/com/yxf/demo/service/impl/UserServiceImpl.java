package com.yxf.demo.service.impl;

import java.util.List;
import java.util.concurrent.TimeUnit;

import javax.annotation.Resource;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Service;

import com.yxf.demo.dao.UserRepository;
import com.yxf.demo.mode.entity.User;
import com.yxf.demo.mode.from.UserSaveFrom;
import com.yxf.demo.service.UserService;

@Service
// Spring 4.0以上不推荐使用注解方式，推荐采用构造器或Setter两种方式
// 该注解主要使用Lombok，内部实际默认采用构造器，使用final进行修饰，使得其必须要初始化
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
	
	//@Autowired是先按类型进行bean注入.如果没有再使用参数名
	
	// @Autowired
	private final UserRepository userRepository;

	/**
	 * @Resource是先按参数名进行bean注入,如果没有再使用类型
	 * 如果这里想要设置属性类型就必须通过@Resource进行注入,因为使用@Autowired注入会找不到
	 * RedisTemplate<String, User>这个类型的RedisTemplate
	 */
	 // @Resource
	 private final RedisTemplate<String, User> redisTemplate;
	
	@Override
	public void saveUser(UserSaveFrom userForm) {
		User user = new User();
		BeanUtils.copyProperties(userForm, user);
		userRepository.save(user);
	}

	@Override
	public List<User> findUser() {
		return userRepository.findAll();
	}

	@Override
	public User findUserRedis(String userName) {
		String key = "user_" + userName;
		// 表明操作String类型
		ValueOperations<String, User> operations = redisTemplate.opsForValue();
		boolean hasKey = redisTemplate.hasKey(key);
		// 代表缓存中存在该值
		if (hasKey) {
			User user = (User) operations.get(key);
			
			return user;
		}
		User user = userRepository.findByUserName(userName);
		/**
		 * 在这里放redis中set对象时必须将对象序列化
		 */
		// 将User对象设置进redis数据库中10秒
		operations.set(key, user, 100, TimeUnit.SECONDS);
		return user;
	}


}
