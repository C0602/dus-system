package com.xd.consumer.base;

import org.apache.rocketmq.client.consumer.DefaultMQPushConsumer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

import java.io.IOException;
import java.util.Properties;

public class CmBaseMqService {
	
	protected static Logger logger = LoggerFactory.getLogger(com.xd.consumer.base.CmBaseMqService.class);

	private static DefaultMQPushConsumer consumer;
	
	static {
		// 从配置文件中获取
		Resource resource = new ClassPathResource("mq.properties");
		Properties p = new Properties();

		try {
			p.load(resource.getInputStream());
		} catch (IOException e) {
			logger.error("消费者，配置文件异常：" + e.getMessage());
		}

		String defaultMqGroup = String.valueOf(p.getProperty("mq.defaultmqgroup"));
		String namesrvAddr = String.valueOf(p.getProperty("mq.namesrvaddr"));
		String instanceName = String.valueOf(p.getProperty("mq.instancename"));
		
		consumer = new DefaultMQPushConsumer(defaultMqGroup);
		consumer.setNamesrvAddr(namesrvAddr);
		consumer.setInstanceName(instanceName);
		
		logger.info("消费者，配置文件值获取成功。defaultMqGroup=" + defaultMqGroup 
				+ "，namesrvAddr=" + namesrvAddr + "，instanceName=" + instanceName);
	}
	
	public static DefaultMQPushConsumer getConsumer() {
		return consumer;
	}
}
