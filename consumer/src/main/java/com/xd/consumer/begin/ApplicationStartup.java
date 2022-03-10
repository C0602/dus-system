package com.xd.consumer.begin;

import com.xd.consumer.service.ConsumerMqService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.event.ContextRefreshedEvent;

@Configuration
public class ApplicationStartup implements ApplicationListener<ContextRefreshedEvent> {

	protected static Logger logger = LoggerFactory.getLogger(com.xd.consumer.begin.ApplicationStartup.class);

	@Autowired
	private ConsumerMqService service;

	@Override
	public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
		// 项目启动后，执行启动消费者方法
		try {
			logger.info("项目启动后，执行启动消费者方法...");
			service.consume(); // 消费者的实现方法
		} catch (Exception e) {
			logger.error("项目启动后，执行启动消费者方法，异常：" + e.getMessage(), e);
		}
	}

}
