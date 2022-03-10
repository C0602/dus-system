package com.xd.point.service.impl;

import com.xd.mq.service.ProducerMqService;
import com.xd.mq.vo.DotAppEventHisVo;
import com.xd.point.service.DotService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DotServiceImpl implements DotService {

	protected static Logger logger = LoggerFactory.getLogger(DotServiceImpl.class);

	@Autowired
	private ProducerMqService producerMqService;
	
	@Override
	public String dot(String appId, String eventId, String traceId) {
		// 二、信息有效
		DotAppEventHisVo dotAppEventHisVo = new DotAppEventHisVo();
		dotAppEventHisVo.setAppId(appId);
		dotAppEventHisVo.setEventId(eventId);
		dotAppEventHisVo.setTraceId(traceId);
		boolean flag =  this.producerMqService.sendDotAppEventHis(dotAppEventHisVo);
		if (flag) {
			return "ok";
		} else {
			logger.error("应用打点数据失败", new RuntimeException("数据埋点失败"));
			return "";
		}
	}

}