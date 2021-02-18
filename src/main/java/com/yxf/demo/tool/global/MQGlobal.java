package com.yxf.demo.tool.global;

/**
 * @Description:MQ常量
 * @author:yxf
 * @date:2020年3月20日
 */
public class MQGlobal {

	/** MQNameSrv地址 */
	public static final String MQ_NAMESRV = "192.168.1.99:9876";
	
	/** MQNameSrv地址 包含主从 */
	public static final String MQ_NAMESRV_M_S = "192.168.1.99:9876;192.168.1.100:9876";
	
	/** MQNameSrv地址 集群 */
	public static final String MQ_NAMESRV_CLUSTER_M_S = "192.168.1.99:9876;192.168.1.100:9876;192.168.1.103:9876;192.168.1.102:9876";
}
