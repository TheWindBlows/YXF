package com.yxf.demo.tool.enums;

/**
 * @author 针对事务消息的应答状态
 *
 */
public enum LocalTransationEnum {
	
	// 消息提交
	COMMIT_MESSAGE,
	
	// 消息回滚
	ROLLBACK_MESSAGE,
	
	//消息未知异常
	UNKNOW				

}
