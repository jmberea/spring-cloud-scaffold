package com.itmuch.cloud.scaffold;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;

import com.itmuch.cloud.scaffold.domain.user.User;

/**
 * 用户微服务，主要用于演示 spring-data-rest
 * @author eacdy
 */
@SpringBootApplication
@EnableDiscoveryClient
@EnableZuulProxy
@EnableHystrix

@Configuration

@ComponentScan
public class UserApplication {
	public static void main(String[] args) {
		SpringApplication.run(UserApplication.class, args);
	}

	@Autowired
	private RepositoryRestConfiguration repositoryRestConfiguration;

	/**
	 * 作用：让spring-data-rest返回主键
	 * 参考：https://jira.spring.io/browse/DATAREST-161
	 * 参考：也可以：https://github.com/eacdy/spring-cloud-microservice-example/blob/master/users-microservice/src/main/java/data/Application.java
	 * 参考：http://stackoverflow.com/questions/25775387/how-to-configure-spring-data-rest-to-return-the-representation-of-the-resource-c
	 */
	@PostConstruct
	public void exposeIds() {
		this.repositoryRestConfiguration.exposeIdsFor(User.class);
	}
}
