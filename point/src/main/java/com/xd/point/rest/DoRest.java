package com.xd.point.rest;

import com.xd.point.GlobalUtils;
import com.xd.point.service.DotService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

/**
 * @author CC 受理接口
 */
@RestController
@RequestMapping(GlobalUtils.PROJECT_PREFIX + "/api/")
public class DoRest {

	protected static Logger logger = LoggerFactory.getLogger(com.xd.point.rest.DoRest.class);
	
	@Autowired
	private DotService dotService;
	
	/**
	 * 打点上报接口
	 * @return
	 */
	@PostMapping(value = "/dot")
	public String dot(String appId, String eventId, String traceId) {
		try {
			return this.dotService.dot(appId, eventId, traceId);
		} catch (Exception e) {
			logger.error("新统一打点上报，数据接口异常：" + e.getMessage(), e);
			return "";
		}
	}

}