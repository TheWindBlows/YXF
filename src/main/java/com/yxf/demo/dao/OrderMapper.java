package com.yxf.demo.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.yxf.demo.mode.entity.Order;

@Mapper
public interface OrderMapper {
	
	/**
	 * @Description:根据订单id查询订单
	 * @param: 订单id
	 * @author:yxf
	 * @date:2020年3月25日
	 */
	@Select("SELECT * FROM BOOKING_ORDER WHERE orderId = #{orderId}")
	public Order findByOrderId(@Param("orderId") String orderId);

}
