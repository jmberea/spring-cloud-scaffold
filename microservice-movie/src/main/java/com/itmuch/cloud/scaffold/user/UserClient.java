package com.itmuch.cloud.scaffold.user;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.hateoas.Resource;
import org.springframework.hateoas.Resources;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "user")
public interface UserClient {

	@RequestMapping("/user/{id}")
	 Resource<User> findById(@RequestParam("id") Long id);
	
	@RequestMapping("/user/search/name")
	Resources<User> findByName(@RequestParam("name") String name);
}
