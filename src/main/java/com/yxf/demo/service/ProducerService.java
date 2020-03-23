package com.yxf.demo.service;

/**
 * @Description:消息发送者接口
 * @author:yxf
 * @date:2020年3月20日
 */
public interface ProducerService {
	
	/**
	 * @Description:消息发送
	 * @param: message 消息信息
	 * @return 是否成功
	 * @throws Exception 异常捕获
	 * @author:yxf
	 * @date:2020年3月20日
	 */
	public boolean messageSentOut(String message) throws Exception;
	
	/**
	 * @Description:顺序发送
	 * @param: message 消息信息
	 * @throws Exception 异常捕获
	 * @author:yxf
	 * @date:2020年3月20日
	 */
	public void messageSentOutOrder(String message) throws Exception;
	
	/**
	 * @Description:事务发送
	 * @param: message 消息信息
	 * @throws Exception 异常捕获
	 * @author:yxf
	 * @date:2020年3月20日
	 */
	public void messageSentOutTransaction(String message) throws Exception;
	
	/**
	 * @Description:批量发送
	 * @param: message 消息信息
	 * @throws Exception 异常捕获
	 * @author:yxf
	 * @date:2020年3月20日
	 */
	public void messageSentOutBroadcasting(String message)throws Exception;

}
