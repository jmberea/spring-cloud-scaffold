package com.itmuch.cloud.scaffold;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.sidecar.EnableSidecar;

/**
 * 使用sidecar作为api gateway，当然也可以使用zuul
 * 可使用：http://HOST:PORT/其他服务的spring.application.name/其他服务暴露的路径
 * 本例：
 * http://localhost:10000/movie/user/user/1
 * http://localhost:10000/user/user/1
 * 注意：如果其他服务的spring.application.name，含有大写字母，会自动转为小写
 * 例如：假设配置的是userA,那路径则是usera
 * @author eacdy
 */
@SpringBootApplication
@EnableSidecar
public class SidecarApiGatewayApplication {
	public static void main(String[] args) {
		SpringApplication.run(SidecarApiGatewayApplication.class, args);
	}
}
