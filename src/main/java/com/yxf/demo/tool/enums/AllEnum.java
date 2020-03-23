package com.yxf.demo.tool.enums;

public enum AllEnum {
	
	/** 未知错误 */
	UNKOWN_ERROR(-1,"未知错误,请与管理员联系!"),
	
	/** 账号被锁，请联系管理员 */
	USER_LOCK(-100,"账号被锁，请联系管理员!"),
	
	/** 成功 */
	SUCCESS(200, "请求已成功!"),

	/** 请求参数错误 */
	PARAMES_ERROR(400, "请求参数错误!"),

	/** 权限不足,或未带token */
	SC_UNAUTHORIZED(401, "访问无效,请重新登陆!"),

	/** 无权限访问 */
	FORBIDDEN(403, "禁止访问!"),

	/** 请求失败 */
	SYSTEM_ERROR(404, "请求失败!"),

	/** 参数校验 */
	PARAMES_NULL(500,"请按要求填写相应参数!"),

	/** 请登陆获取TOKEN */
	TOKEN_NULL(501,"访问服务异常,请重新登陆!"),
	
	/** 请登陆获取TOKEN */
	TOKEN_ERROR(501,"信息失效,请重新登陆!"),
	
	/** 验证码错误 */
	CODE_ERROR(505,"验证码错误!"),
	
	/** 验证码错误 */
	CODE_NULL(505,"验证码不能为空!"),

	/** 网关异常 */
	GATEWAY_ERROR(504, "网关转发超时!"),
	
	/** 登出 */
	LOGIN_OUT(200, "登出"),
	
	/** 线程执行中状态 */
	THREAD_STATUS_UNKNOW(0, "线程执行中状态"),
	
	/** 线程执行成功状态 */
	THREAD_STATUS_SUCCESS(1, "线程执行成功状态"),
	
	/** 线程执行失败状态 */
	THREAD_STATUS_ERROR(2, "线程执行失败状态");
	
	private Integer code;

	private String msg;

	/**
	 * Description：创建一个新的实例 HttpCodeEnum. <br>
	 * author：袁小飞 <br>
	 * date：2019年5月28日 下午3:58:53 <br>
	 */
	private AllEnum(Integer code, String msg) {
		this.code = code;
		this.msg = msg;
	}

	/**
	 * Description：获取基本响应结果的Code<br>
	 * author：袁小飞 <br>
	 * date：2019年5月28日 下午3:59:07 <br>
	 */
	public Integer getCode() {
		return code;
	}

	/**
	 * Description：获取基本响应结果的Msg <br>
	 * author：袁小飞 <br>
	 * date：2019年5月28日 下午3:59:18 <br>
	 */
	public String getMsg() {
		return msg;
	}
}
