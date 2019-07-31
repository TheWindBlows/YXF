package com.yxf.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.yxf.demo.mode.entity.User;
import com.yxf.demo.mode.from.UserSaveFrom;
import com.yxf.demo.service.UserService;
import com.yxf.demo.tool.enums.AllEnum;
import com.yxf.demo.tool.result.ResultObject;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.extern.log4j.Log4j2;

@RestController
@RequestMapping("/user")
@Log4j2
@Api(tags = "用户管理层")
public class UserController {
	
	@Autowired
	private UserService userService;

	@ApiOperation("用户新增")
	@PostMapping("/saveUser")
	public Object saveUser(@RequestBody @ApiParam UserSaveFrom userForm) {
		userService.saveUser(userForm);
		ResultObject result = new ResultObject();
		result.setResultCode(AllEnum.SUCCESS.getCode());
		return result;
	}
	
	@ApiOperation("用户查询")
	@GetMapping("/findUser")
	public Object findUser() {
		List<User> users = userService.findUser();
		ResultObject result = new ResultObject();
		result.setResultData(users);
		result.setResultCode(AllEnum.SUCCESS.getCode());
		return result;
	}
	
	@ApiOperation("redis查询User")
	@GetMapping("/findUserRedis")
	public Object findUserRedis(String userName) {
		User user = userService.findUserRedis(userName);
		ResultObject result = new ResultObject();
		result.setResultData(user);
		result.setResultCode(AllEnum.SUCCESS.getCode());
		return result;
	}
	
}
