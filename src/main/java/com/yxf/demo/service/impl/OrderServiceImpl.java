package com.yxf.demo.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yxf.demo.dao.OrderMapper;
import com.yxf.demo.dao.xmlmapper.XmlOrderMapper;
import com.yxf.demo.mode.entity.Order;
import com.yxf.demo.service.OrderService;

@Service
public class OrderServiceImpl implements OrderService {
	
	/** 使用xml方式就无法使用注解方式 */
	//@Autowired
	//public OrderMapper orderMapper;
	
	@Autowired
	public XmlOrderMapper xmlOrderMapper;
	
	@Override
	public Order findByOrderId(String orderId) {
		return null;
		//return orderMapper.findByOrderId(orderId);
	}

	@Override
	public Order findXmlByOrderId(String orderId) {
		return xmlOrderMapper.findXmlByOrderId(orderId);
	}

}
