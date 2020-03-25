package com.yxf.demo.service;

import com.yxf.demo.mode.entity.Order;

public interface OrderService {
	
	/**
	 * @Description:根据订单id查询订单
	 * @param: 订单id
	 * @author:yxf
	 * @date:2020年3月25日
	 */
	public Order findByOrderId(String orderId);
	
	/**
	 * @Description:通过XML根据订单id查询订单
	 * @param: 订单id
	 * @author:yxf
	 * @date:2020年3月25日
	 */
	public Order findXmlByOrderId(String orderId);

}
