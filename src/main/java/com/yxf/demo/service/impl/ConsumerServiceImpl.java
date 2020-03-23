package com.yxf.demo.service.impl;

import java.io.UnsupportedEncodingException;
import java.util.List;

import org.apache.rocketmq.client.consumer.DefaultMQPushConsumer;
import org.apache.rocketmq.client.consumer.listener.ConsumeConcurrentlyContext;
import org.apache.rocketmq.client.consumer.listener.ConsumeConcurrentlyStatus;
import org.apache.rocketmq.client.consumer.listener.ConsumeOrderlyContext;
import org.apache.rocketmq.client.consumer.listener.ConsumeOrderlyStatus;
import org.apache.rocketmq.client.consumer.listener.MessageListenerConcurrently;
import org.apache.rocketmq.client.consumer.listener.MessageListenerOrderly;
import org.apache.rocketmq.common.message.MessageExt;
import org.apache.rocketmq.common.protocol.heartbeat.MessageModel;
import org.apache.rocketmq.remoting.common.RemotingHelper;
import org.springframework.stereotype.Service;

import com.yxf.demo.service.ConsumerService;
import com.yxf.demo.tool.Global.MQGlobal;

/**
 * @Description:消费者实现
 * @author:yxf
 * @date:2020年3月20日
 */
@Service
public class ConsumerServiceImpl implements ConsumerService {

	@Override
	public void receiveMessage() throws Exception {
		// 创建DefaultMQPushConsumer接收组
		DefaultMQPushConsumer pushConsumer = new DefaultMQPushConsumer("yxf_consumer_group");
		// 设置NameSrv地址
		pushConsumer.setNamesrvAddr(MQGlobal.MQ_NAMESRV);
		// 设置消息拉取上限
		pushConsumer.setMaxReconsumeTimes(5);
		// 设置需要消费的主题与标签消息
		pushConsumer.subscribe("Topic_Demo", "*");
		// 设置消息的监听
		pushConsumer.setMessageListener(new MessageListenerConcurrently() {
			// 可一次性拉取多条消息
			@Override
			public ConsumeConcurrentlyStatus consumeMessage(List<MessageExt> msgs, ConsumeConcurrentlyContext context) {
				// 迭代消息集合
				for (MessageExt messageExt : msgs) {
					try {
						// 获取主题
						String topic = messageExt.getTopic();
						// 获取标签
						String tags = messageExt.getTags();
						// 获取唯一key
						String keys = messageExt.getKeys();
						// 获取消息
						String result = new String(messageExt.getBody(),RemotingHelper.DEFAULT_CHARSET);
						StringBuilder s = new StringBuilder();
						s.append("消费者信息：");
						s.append("topic=").append(topic).append("|");
						s.append("tags=").append(tags).append("|");
						s.append("keys=").append(keys).append("|");
						s.append("result=").append(result);
						System.out.println(s.toString());
					} catch (UnsupportedEncodingException e) {
						e.printStackTrace();
						// 消息重试
						return ConsumeConcurrentlyStatus.RECONSUME_LATER;
					}
				}
				// 消息消费成功
				return ConsumeConcurrentlyStatus.CONSUME_SUCCESS;
			}
		});
		// 开启DefaultMQPushConsumer
		pushConsumer.start();
	}

	@Override
	public void receiveMessageOrder() throws Exception {
		// 创建DefaultMQPushConsumer接收组
		DefaultMQPushConsumer pushConsumer = new DefaultMQPushConsumer("yxf_consumer_group");
		// 设置NameSrv地址
		pushConsumer.setNamesrvAddr(MQGlobal.MQ_NAMESRV);
		// 设置消息拉取上限
		pushConsumer.setMaxReconsumeTimes(5);
		// 设置需要消费的主题与标签消息
		pushConsumer.subscribe("Topic_Demo_tansaction", "*");
		// 设置消息的监听
		pushConsumer.setMessageListener(new MessageListenerOrderly() {
			// 可一次性拉取多条消息
			@Override
			public ConsumeOrderlyStatus consumeMessage(List<MessageExt> msgs, ConsumeOrderlyContext context) {
				// 迭代消息集合
				for (MessageExt messageExt : msgs) {
					try {
						// 获取主题
						String topic = messageExt.getTopic();
						// 获取标签
						String tags = messageExt.getTags();
						// 获取唯一key
						String keys = messageExt.getKeys();
						// 获取消息
						String result = new String(messageExt.getBody(),RemotingHelper.DEFAULT_CHARSET);
						StringBuilder s = new StringBuilder();
						s.append("消费者信息：");
						s.append("topic=").append(topic).append("|");
						s.append("tags=").append(tags).append("|");
						s.append("keys=").append(keys).append("|");
						s.append("result=").append(result);
						System.out.println(s.toString());
					} catch (UnsupportedEncodingException e) {
						e.printStackTrace();
						// 消息重试
						return ConsumeOrderlyStatus.SUSPEND_CURRENT_QUEUE_A_MOMENT;
					}
				}
				// 消息消费成功
				return ConsumeOrderlyStatus.SUCCESS;
			}
		});
		// 开启DefaultMQPushConsumer
		pushConsumer.start();
	}

	@Override
	public void receiveMessageBroadcasting() throws Exception {
		// 创建DefaultMQPushConsumer接收组
		DefaultMQPushConsumer pushConsumer = new DefaultMQPushConsumer("yxf_consumer_group");
		// 设置NameSrv地址
		pushConsumer.setNamesrvAddr(MQGlobal.MQ_NAMESRV);
		// 设置消息拉取上限
		pushConsumer.setMaxReconsumeTimes(5);
		// 设置需要消费的主题与标签消息
		pushConsumer.subscribe("Topic_Cluster_Demo", "*");
		// 设置广播模式，默认集群模式（广播=所有订阅者都能获取消息；集群=所有订阅者中只有一个能获取消息）
		pushConsumer.setMessageModel(MessageModel.BROADCASTING);
		// 设置消息的监听
		pushConsumer.setMessageListener(new MessageListenerConcurrently() {
			// 可一次性拉取多条消息
			@Override
			public ConsumeConcurrentlyStatus consumeMessage(List<MessageExt> msgs, ConsumeConcurrentlyContext context) {
				// 迭代消息集合
				for (MessageExt messageExt : msgs) {
					try {
						// 获取主题
						String topic = messageExt.getTopic();
						// 获取标签
						String tags = messageExt.getTags();
						// 获取唯一key
						String keys = messageExt.getKeys();
						// 获取消息
						String result = new String(messageExt.getBody(),RemotingHelper.DEFAULT_CHARSET);
						StringBuilder s = new StringBuilder();
						s.append("消费者信息：");
						s.append("topic=").append(topic).append("|");
						s.append("tags=").append(tags).append("|");
						s.append("keys=").append(keys).append("|");
						s.append("result=").append(result);
						System.out.println(s.toString());
					} catch (UnsupportedEncodingException e) {
						e.printStackTrace();
						// 消息重试
						return ConsumeConcurrentlyStatus.RECONSUME_LATER;
					}
				}
				// 消息消费成功
				return ConsumeConcurrentlyStatus.CONSUME_SUCCESS;
			}
		});
		// 开启DefaultMQPushConsumer
		pushConsumer.start();
	}

}
