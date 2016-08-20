package com.itmuch.cloud.scaffold.hystrixdashboard;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;

/**
 * 测试步骤:
 * 1. 访问http://localhost:7979/hystrix.stream 可以查看dashboard
 * 2. 在上面的输入框填入: http://localhost:8001/hystrix.stream 或 http://localhost:8002/hystrix.stream 进行测试
 * 注意：首先要先调用一下user或者movie服务里面的API，否则将会显示一个空的图表.
 * @author eacdy
 */
@SpringBootApplication
@EnableHystrixDashboard
public class HystrixDashboardApplication {
	public static void main(String[] args) {
		new SpringApplicationBuilder(HystrixDashboardApplication.class).web(true).run(args);
	}
}
