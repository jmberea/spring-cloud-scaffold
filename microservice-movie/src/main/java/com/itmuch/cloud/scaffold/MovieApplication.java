package com.itmuch.cloud.scaffold;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

/**
 * 电影微服务，主要用于演示 feign
 * @author eacdy
 */
@SpringBootApplication
@EnableFeignClients
@EnableWebMvc
@EnableAutoConfiguration
@EnableDiscoveryClient
@EnableZuulProxy
@EnableHystrix
public class MovieApplication {
	public static void main(String[] args) {
		SpringApplication.run(MovieApplication.class, args);
	}
}
