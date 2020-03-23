package com.yxf.demo.service;

/**
 * @Description:消费者接口
 * @author:yxf
 * @date:2020年3月20日
 */
public interface ConsumerService {
	
	/**
	 * @Description:消费信息
	 * @author:yxf
	 * @throws Exception 异常
	 * @date:2020年3月20日
	 */
	public void receiveMessage() throws Exception;
	
	/**
	 * @Description:顺序消费信息
	 * @author:yxf
	 * @throws Exception 异常
	 * @date:2020年3月20日
	 */
	public void receiveMessageOrder() throws Exception;
	
	/**
	 * @Description:广播消费信息
	 * @author:yxf
	 * @throws Exception 异常
	 * @date:2020年3月20日
	 */
	public void receiveMessageBroadcasting() throws Exception;

}
