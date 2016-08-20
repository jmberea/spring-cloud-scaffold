package com.itmuch.cloud.scaffold.repository.user;

import java.util.List;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;

import com.itmuch.cloud.scaffold.domain.user.User;

/**
 * 使用spring-data-rest，直接将接口暴露出去。
 * 注意：目前spring-data-rest官方只支持：Spring Data JPA、Spring Data MongoDB、Spring Data Neo4j、Spring Data GemFire、Spring Data Cassandra
 * 参考文档：http://docs.spring.io/spring-data/rest/docs/current/reference/html/#getting-started.bootstrap
 * 
 * @author eacdy
 */
@RepositoryRestResource(collectionResourceRel = "user", path = "user")
public interface UserRepository extends PagingAndSortingRepository<User, Long> {

	/**
	 * 默认玩法
	 * 可访问  http://localhost:8001/user/search/findByNameStartingWith?name=T 测试
	 * @param name 标题
	 * @return 对应的movie
	 */
	List<User> findByNameStartingWith(@Param("name") String name);

	/**
	 * @RestResource 的两个参数，主要是对其路径以及其描述进行指定
	 * 可访问	http://localhost:8001/user/search 对比一下页面上的两个接口的描述有什么区别即可。
	 * 访问 		http://localhost:8001/user/search/name?name=Tom
	 * @param name 标题
	 * @return 对应的movie
	 */
	@RestResource(path = "name", rel = "name")
	List<User> findByName(@Param("name") String name);
}
