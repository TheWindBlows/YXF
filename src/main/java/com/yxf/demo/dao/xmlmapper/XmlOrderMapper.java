package com.yxf.demo.dao.xmlmapper;

import org.apache.ibatis.annotations.Param;

import com.yxf.demo.mode.entity.Order;

public interface XmlOrderMapper {

	public Order findXmlByOrderId(@Param("orderId") String orderId);
	
}
