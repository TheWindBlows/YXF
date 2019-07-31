package com.yxf.demo.tool.result;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class ResultExceptionObject extends RuntimeException {

	private static final long serialVersionUID = 394255612725047967L;
	
	/** 错误代码 */
	private Integer code; 
	
	/** 参数用来补充说明异常消息，如需提示用户在某IP处登录可以设置消息 */
	private String params; 
	
	/**
	 * Description：创建一个新的实例 <br>
	 * author：袁小飞 <br>
	 * date：2019年5月28日 下午4:04:54 <br>
	 */
	public ResultExceptionObject(Integer code, String params) {
		this.code = code;
		this.params = params;
	}
	
}
