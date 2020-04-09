package com.yxf.demo.tool.result;

import com.yxf.demo.tool.enums.AllEnum;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.Accessors;

@Getter
@Setter
@ToString
// 添加链式编程
@Accessors(chain = true)
public class ResultObject {

	private Integer resultCode;
	
	private String resultMsg;
	
	private Object resultData;
	
	public ResultObject() {
		this.resultCode = AllEnum.SUCCESS.getCode();
	}

	public ResultObject(Integer resultCode, String resultMsg, Object resultData) {
		super();
		this.resultMsg = resultMsg;
		this.resultData = resultData;
		this.resultCode = resultCode;
	}
	
}
