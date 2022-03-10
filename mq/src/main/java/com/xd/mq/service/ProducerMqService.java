package com.xd.mq.service;

import com.xd.mq.vo.DotAppEventHisVo;

public interface ProducerMqService {

	// 定义主题，一般一个项目，使用同一个
	public static String TOPIC = "XdTopic";

	//================================
	// 定义Tag，实际业务
	//================================
	/**
	 *  应用事件打点
	 */
	public static String TAG_DOT_APP_EVENT_HIS = "tagDotAppEventHis";

	public boolean sendDotAppEventHis(DotAppEventHisVo dotAppEventHisVo);
	
}
