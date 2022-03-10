package com.xd.mq.base;

import com.alibaba.fastjson.JSON;
import org.apache.rocketmq.client.producer.DefaultMQProducer;
import org.apache.rocketmq.client.producer.SendCallback;
import org.apache.rocketmq.client.producer.SendResult;
import org.apache.rocketmq.common.message.Message;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

import java.io.IOException;
import java.util.Properties;

/**
 * MQ生产者，服务层
 *
 * @author CC
 *
 */
public class PdBaseMqService {

	protected static Logger logger = LoggerFactory.getLogger(com.xd.mq.base.PdBaseMqService.class);

	// 发送超时时间
	private static long TIMEOUT = 10000;

	private static DefaultMQProducer producer;

	static {
		// 从配置文件中获取
		Resource resource = new ClassPathResource("mq.properties");
		Properties p = new Properties();

		try {
			p.load(resource.getInputStream());
		} catch (IOException e) {
			logger.error("配置文件异常");
		}

		producer = new DefaultMQProducer(String.valueOf(p.getProperty("mq.defaultmqgroup")));
		producer.setNamesrvAddr(String.valueOf(p.getProperty("mq.namesrvaddr")));
		producer.setInstanceName(String.valueOf(p.getProperty("mq.instancename")));

		try {
			producer.start();
			producer.setRetryTimesWhenSendAsyncFailed(2);
			logger.info("MQ生产者，Producer Started...");
		} catch (Exception e) {
			logger.error("MQ生产者，异常：" + e.getMessage(), e);
		}
	}

	public static boolean sendMsg(String topic, String tags, Object object) {
		try {

			Message message = new Message(topic, tags, JSON.toJSONString(object).getBytes());
			logger.info("MQ生产者，【异步】发送消息：topic=" + topic + "，tags=" + tags);

			// 异步发送
			producer.send(message, new SendCallback() {
				@Override
				public void onSuccess(SendResult sendResult) {
					//logger.info("消息发送结果：result=" + sendResult.getSendStatus().name() + "，msgId=" + sendResult.getMsgId());
				}

				@Override
				public void onException(Throwable e) {
					logger.error("消息发送结果，异常了：" + e.getMessage(), e);
				}
			}, TIMEOUT);

		} catch (Exception e) {
			logger.error("MQ生产者，发送消息，异常：" + e.getMessage(), e);
			return false;
		}
		return true;
	}
}
