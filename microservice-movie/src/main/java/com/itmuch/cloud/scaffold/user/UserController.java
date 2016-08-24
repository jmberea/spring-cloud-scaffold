package com.itmuch.cloud.scaffold.user;

import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.Resources;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@RestController
public class UserController {
	@Autowired
	private UserClient userClient;

	/**
	 * 这边user-by-id不能写成user，否则会404，原因还没分析出来。
	 * 经过测试，当路径和其他服务名称相同时，会出现这种情况。
	 * @param id id
	 * @return id对应的用户
	 */
	@GetMapping("user-by-id/{id}")
	@HystrixCommand(fallbackMethod = "fallback")
	public User userById(@PathVariable Long id) {
		return this.userClient.findById(id).getContent();
	}

	@GetMapping("user-by-name/{name}")
	public Collection<User> findByName(@PathVariable String name) {
		Resources<User> findByName = this.userClient.findByName(name);
		return findByName.getContent();
	}

	public User fallback(Long id) {
		return null;
	}
}
