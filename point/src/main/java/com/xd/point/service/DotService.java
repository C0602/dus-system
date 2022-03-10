package com.xd.point.service;

import javax.servlet.http.HttpServletRequest;

/**
 * 打点服务
 * 
 */
public interface DotService {

	/**
	 * 打点上报
	 * @param appId		项目ID
	 * @param eventId	事件ID
	 * @param traceId	跟踪ID
	 * @return
	 */
	public String dot(String appId, String eventId, String traceId);
}