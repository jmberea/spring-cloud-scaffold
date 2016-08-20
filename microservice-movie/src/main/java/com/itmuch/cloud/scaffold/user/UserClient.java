package com.itmuch.cloud.scaffold.user;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.hateoas.Resource;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * 访问：http://HOST:PORT/其他服务的spring.application.name/其他服务暴露的路径
 * 本例可访问：http://localhost:8002/user/user/search
 * 注意：如果其他服务的spring.application.name，含有大写字母，会自动转为小写
 * 例如：假设配置的是userA,那路径则是usera
 * @author eacdy
 */
@FeignClient(name = "user", url = "http://localhost:8001/user")
public interface UserClient {

	@RequestMapping("/{id}")
	public Resource<User> findById(@RequestParam("id") Long id);
}
