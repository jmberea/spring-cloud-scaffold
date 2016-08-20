package com.itmuch.cloud.scaffold.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@RestController
public class UserController {
	@Autowired
	private UserClient userClient;

	@GetMapping("test/{id}")
	@HystrixCommand(fallbackMethod = "fallback")
	public User test(@PathVariable Long id) {
		User user = this.userClient.findById(id).getContent();
		return user;
	}

	public User fallback(Long id) {
		return new User();
	}

}
