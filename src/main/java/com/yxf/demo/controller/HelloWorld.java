package com.yxf.demo.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;

@RestController
@Api(tags = "登陆")
public class HelloWorld {
	
	@PostMapping("/login")
	public Object login(String userName,String passWord) {
		ConcurrentHashMap<String, String> c1 = new ConcurrentHashMap<String, String>();
		c1.get("123");
		c1.put("123", "123");
		ArrayList<String> a= new ArrayList<>();
		HashMap<String, String> m = new HashMap<String, String>();
		m.put("123", "123");
		Object o = new Object();
		StringBuffer s2 = new StringBuffer();
		s2.append("");
		StringBuilder s3 = new StringBuilder();
		s3.append("");
		Set<String> s = new HashSet<>();
		String s1 = "123";
		CopyOnWriteArrayList<String> c = new CopyOnWriteArrayList<>();
		c.add(s1);
		s1.substring(1);
        return "login";
	}
	
}
