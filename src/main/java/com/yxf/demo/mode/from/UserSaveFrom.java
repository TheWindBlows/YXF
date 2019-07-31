package com.yxf.demo.mode.from;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@ApiModel(value = "用户对象")
public class UserSaveFrom {

	@ApiModelProperty(value="用户名")
	private String userName;
	
	@ApiModelProperty(value="密码")
	private String passWord;
}
