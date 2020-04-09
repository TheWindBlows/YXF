package com.yxf.demo.mode.entity;

import lombok.Data;
import lombok.experimental.Accessors;

// 添加链式编程
@Accessors(chain = true)
@Data
public class Order {
	
	public String orderId;
	
	public String name;
}
