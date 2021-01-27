package com.yxf.demo.mode.from;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Getter
@Setter
@ToString
@ApiModel(value = "用户对象")
public class UserSaveFrom {


	@NotBlank(message = "用户名不能为空")
	@Length(min = 3, max = 20, message = "用户名称长度必须在3~20之间")
	// 在Swagger中代表必填
	@ApiModelProperty(value="用户名", required = true)
	private String userName;

	@NotBlank(message = "密码不能为空")
	@Length(min = 6, max = 18, message = "密码称长度必须在6~20之间")
	@ApiModelProperty(value="密码", required = true)
	private String passWord;
}
