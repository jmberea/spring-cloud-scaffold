package com.itmuch.cloud.scaffold;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.sidecar.EnableSidecar;

/**
 * 使用sidecar作为api gateway，当然也可以使用zuul
 * 可使用：http://HOST:PORT/其他服务名称/其他服务path访问测试。
 * 本例：
 * http://localhost:10000/movie/user/user/1
 * http://localhost:10000/user/user/1
 * @author eacdy
 */
@SpringBootApplication
@EnableSidecar
public class SidecarApiGatewayApplication {
	public static void main(String[] args) {
		SpringApplication.run(SidecarApiGatewayApplication.class, args);
	}
}
