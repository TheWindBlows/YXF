package com.yxf.demo.tool.result;

import com.yxf.demo.tool.enums.AllEnum;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
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
