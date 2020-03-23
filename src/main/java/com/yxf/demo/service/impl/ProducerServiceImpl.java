package com.yxf.demo.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

import org.apache.rocketmq.client.producer.DefaultMQProducer;
import org.apache.rocketmq.client.producer.LocalTransactionState;
import org.apache.rocketmq.client.producer.MessageQueueSelector;
import org.apache.rocketmq.client.producer.SendResult;
import org.apache.rocketmq.client.producer.SendStatus;
import org.apache.rocketmq.client.producer.TransactionListener;
import org.apache.rocketmq.client.producer.TransactionMQProducer;
import org.apache.rocketmq.client.producer.TransactionSendResult;
import org.apache.rocketmq.common.message.Message;
import org.apache.rocketmq.common.message.MessageExt;
import org.apache.rocketmq.common.message.MessageQueue;
import org.apache.rocketmq.remoting.common.RemotingHelper;
import org.springframework.stereotype.Service;

import com.yxf.demo.service.ProducerService;
import com.yxf.demo.tool.Global.MQGlobal;
import com.yxf.demo.tool.enums.AllEnum;

/**
 * @Description:消费者实现
 * @author:yxf
 * @date:2020年3月20日
 */
@Service
public class ProducerServiceImpl implements ProducerService {

	@Override
	public boolean messageSentOut(String message) throws Exception {
		// 创建DefaultMQProducer发送组
		DefaultMQProducer producer = new DefaultMQProducer("yxf_producer_cluster_group");
		// 设置NameSrv地址
		producer.setNamesrvAddr(MQGlobal.MQ_NAMESRV);
		// 开启DefaultMQProducer
		producer.start();
		// 创建消息Message
		// 参数：主题别名；标签-用于消息过滤；消息唯一值；消息内容（设置编码格式）
		Message m = new Message("Topic_Cluster_Demo","Yxf","Key_1",message.getBytes(RemotingHelper.DEFAULT_CHARSET));
		// 发送消息
		SendResult result = producer.send(m);
		System.out.println(result);
		//　关闭DefaultMQProducer
		producer.shutdown();
		if (SendStatus.SEND_OK.equals(result.getSendStatus())) {
			return true;
		}
		return false;
	}

	@Override
	public void messageSentOutOrder(String message) throws Exception {
		// 创建DefaultMQProducer发送组
		DefaultMQProducer producer = new DefaultMQProducer("yxf_producer_group");
		// 设置NameSrv地址
		producer.setNamesrvAddr(MQGlobal.MQ_NAMESRV);
		// 开启DefaultMQProducer
		producer.start();
		// 发送5条消息
		for (int i = 0; i < 5; i++) {
			// 创建消息Message
			// 参数：主题别名；标签-用于消息过滤；消息唯一值；消息内容（设置编码格式）
			Message m = new Message("Topic_Demo_Order","Yxf","Key_2",(message + i).getBytes(RemotingHelper.DEFAULT_CHARSET));
			// 参数：消息信息；选中指定的消息队列对象；指定对应的队列下标
			SendResult result = producer.send(
					m,
					new MessageQueueSelector() {
						@Override
						public MessageQueue select(List<MessageQueue> mqs, Message msg, Object arg) {
							//　获取外部参数设定的队列的下标
							Integer index = (Integer) arg;
							// 获取对应下标的队列
							return mqs.get(index);
						}
					},
					1);
			System.out.println(result);
		}
		//　关闭DefaultMQProducer
		producer.shutdown();
	}

	@Override
	public void messageSentOutTransaction(String message) throws Exception {
		// 创建TransactionMQProducer发送组
		TransactionMQProducer producer = new TransactionMQProducer("tansaction_producer_group");
		// 设置NameSrv地址
		producer.setNamesrvAddr(MQGlobal.MQ_NAMESRV);
		// 指定消息监听对象，用于执行本地事务和消息回查
		producer.setTransactionListener(new TransactionListenerImpl());
		// 创建线程池，因为执行本事事务与消息回查都是多线程操作
		ExecutorService pool = new ThreadPoolExecutor(
											2, 
											5, 
											100, 
											TimeUnit.SECONDS, 
											new ArrayBlockingQueue<>(200),
											new ThreadFactory() {
												@Override
												public Thread newThread(Runnable r) {
													Thread thread = new Thread(r);
													thread.setName("transaction-thread");
													return thread;
												}
											});
		// 设置 线程池
		producer.setExecutorService(pool);
		// 开启DefaultMQProducer
		producer.start();
		// 发送条消息
		// 创建消息Message
		// 参数：主题别名；标签-用于消息过滤；消息唯一值；消息内容（设置编码格式）
		Message m = new Message("Topic_Demo_tansaction","Yxf","Key_3",message.getBytes(RemotingHelper.DEFAULT_CHARSET));
		// 发送事务消息
		// 参数：消息内容；事务监听标识
		TransactionSendResult result = producer.sendMessageInTransaction(m, "yxf-tansaction");
		System.out.println(result);
		//　关闭DefaultMQProducer
		producer.shutdown();
	}

	@Override
	public void messageSentOutBroadcasting(String message) throws Exception {
		// 创建DefaultMQProducer发送组
		DefaultMQProducer producer = new DefaultMQProducer("yxf_producer_group");
		// 设置NameSrv地址
		producer.setNamesrvAddr(MQGlobal.MQ_NAMESRV);
		// 开启DefaultMQProducer
		producer.start();
		List<Message> messageList = new ArrayList<Message>();
		for (int i = 0; i < 10; i++) {
			// 创建消息Message
			// 参数：主题别名；标签-用于消息过滤；消息唯一值；消息内容（设置编码格式）
			Message m = new Message("Topic_Demo","Yxf","Key_1",(message + i).getBytes(RemotingHelper.DEFAULT_CHARSET));
			messageList.add(m);
		}
		// 发送消息
		SendResult result = producer.send(messageList);
		System.out.println(result);
		//　关闭DefaultMQProducer
		producer.shutdown();
	}

}

class TransactionListenerImpl implements TransactionListener{
	
	// 存储对应事务的状态信息；key=事务id value=状态
	private ConcurrentHashMap<String, Integer> localTrans = new ConcurrentHashMap<String, Integer>();

	/**
	 * @Description:执行本地事务
	 * @author:yxf
	 * @date:2020年3月20日
	 */
	@Override
	public LocalTransactionState executeLocalTransaction(Message msg, Object arg) {
		// 获取事务的Id
		String transactionId = msg.getTransactionId();
		localTrans.put(transactionId, AllEnum.THREAD_STATUS_UNKNOW.getCode());
		/**
		 * 执行本地业务，开启本地的事务
		 * 如果事务完成返回成功状态
		 * 事务失败则返回回滚状态
		 */
		System.out.println("执行业务");
		try {
			Thread.sleep(50000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			localTrans.put(transactionId, AllEnum.THREAD_STATUS_ERROR.getCode());
			return LocalTransactionState.ROLLBACK_MESSAGE;
		}
		localTrans.put(transactionId, AllEnum.THREAD_STATUS_SUCCESS.getCode());
		return LocalTransactionState.COMMIT_MESSAGE;
	}

	/**
	 * @Description:消息回查
	 * @author:yxf
	 * @date:2020年3月20日
	 */
	@Override
	public LocalTransactionState checkLocalTransaction(MessageExt msg) {
		// 获取对应事务的ID的状态
		String transactionId = msg.getTransactionId();
		Integer status = localTrans.get(transactionId);
		
		System.out.println("消息回查----id="+transactionId+"------status="+status.toString());
		
		switch (status) {
			case 0:
				return LocalTransactionState.UNKNOW;
			case 1:
				return LocalTransactionState.COMMIT_MESSAGE;
			case 2:
				return LocalTransactionState.ROLLBACK_MESSAGE;
		}
		return LocalTransactionState.UNKNOW;
	}
}
