package com.yxf.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.yxf.demo.mode.entity.Order;
import com.yxf.demo.service.OrderService;
import com.yxf.demo.tool.enums.AllEnum;
import com.yxf.demo.tool.result.ResultObject;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

/**
 * @Description:订单Controller
 * @author:yxf
 * @date:2020年3月25日
 */
@RestController
@RequestMapping("/order")
@Api(tags = "订单管理层")
public class OrderController {
	
	@Autowired
	private OrderService orderService;

	@ApiOperation("根据订单Id查询订单")
	@GetMapping("/findByOrderId")
	public Object findByOrderId(@RequestParam String orderId) {
		Order order = orderService.findByOrderId(orderId);
		ResultObject result = new ResultObject();
		result.setResultCode(AllEnum.SUCCESS.getCode());
		result.setResultData(order);
		return result;
	}
	
	@ApiOperation("通过xml根据订单Id查询订单")
	@GetMapping("/findXmlByOrderId")
	public Object findXmlByOrderId(@RequestParam String orderId) {
		Order order = orderService.findXmlByOrderId(orderId);
		ResultObject result = new ResultObject();
		result.setResultCode(AllEnum.SUCCESS.getCode());
		result.setResultData(order);
		return result;
	}

}
