package com.xd.mq.service.impl;

import com.xd.mq.base.PdBaseMqService;
import com.xd.mq.service.ProducerMqService;
import com.xd.mq.vo.DotAppEventHisVo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author CC
 *
 */
public class ProducerMqServiceImpl implements ProducerMqService {

	protected static Logger logger = LoggerFactory.getLogger(com.xd.mq.service.impl.ProducerMqServiceImpl.class);

	@Override
	public boolean sendDotAppEventHis(DotAppEventHisVo dotAppEventHisVo) {
		try {
			return PdBaseMqService.sendMsg(ProducerMqService.TOPIC, ProducerMqService.TAG_DOT_APP_EVENT_HIS, dotAppEventHisVo);
		} catch (Exception e) {
			logger.error("mq异步化：应用事件打点异常：" + e.getMessage(), e);
			return false;
		}
	}
}
