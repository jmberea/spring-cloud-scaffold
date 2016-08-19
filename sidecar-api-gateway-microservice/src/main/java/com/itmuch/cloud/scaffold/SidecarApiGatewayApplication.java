package com.itmuch.cloud.scaffold;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.sidecar.EnableSidecar;

/**
 * 使用sidecar作为api gateway，当然也可以使用zuul
 * @author eacdy
 */
@SpringBootApplication
@EnableSidecar
public class SidecarApiGatewayApplication {
	public static void main(String[] args) {
		SpringApplication.run(SidecarApiGatewayApplication.class, args);
	}
}
