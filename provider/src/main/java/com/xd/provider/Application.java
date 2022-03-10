package com.xd.provider;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ImportResource;

/**
 * @author CC
 */
@SpringBootApplication
// 使用 providers.xml 配置
@ImportResource(value = { "classpath:providers.xml" })
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(com.xd.provider.Application.class, args);
	}
}
