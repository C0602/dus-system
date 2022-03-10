package com.xd.point;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

/**
 * 拦截器定义
 * @author CC
 */
@Configuration
public class WebConfig extends WebMvcConfigurationSupport {

	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		//定义过滤拦截的url名称
		registry.addInterceptor(new HttpInterceptor()).addPathPatterns(GlobalUtils.PROJECT_PREFIX + "/**");
	}
	
}
