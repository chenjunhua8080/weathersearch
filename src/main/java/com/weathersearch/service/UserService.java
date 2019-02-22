package com.weathersearch.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Order;
import org.springframework.stereotype.Service;

import com.weathersearch.dao.UserDao;
import com.weathersearch.entity.User;

@RefreshScope
@Service
public class UserService {

	@Autowired
	private UserDao userDao;
	
	@Value("${page.size.weather}")
	private int size;

	public User getUser(Long id) {
		User user = userDao.getOne(id);
		return user;
	}

	public Page<User> getUserList(Integer page) {
		// 条件匹配器
		ExampleMatcher exampleMatcher = ExampleMatcher.matching()
			.withMatcher("name",ExampleMatcher.GenericPropertyMatchers.endsWith())//默认不区分大小写?
			.withIgnorePaths("createDate");
		// 匹配模型
		Example<User> example = Example.of(new User("t956", null), exampleMatcher);
		// 分页、多个排序条件
		List<Order> orders = new ArrayList<>();
		orders.add(Order.by("id"));// by默认升序
//		orders.add(Order.desc("name"));
		// 加上排序页数越大会变慢，不加会不会乱?
		Pageable pageable = PageRequest.of(page, size, Sort.by(orders));
		Page<User> list = userDao.findAll(example, pageable);
		return list;
	}

	public User register(String name, String pass) {
		User save = userDao.save(new User(name, pass));
		return save;
	}

	public void setSize(int size) {
		this.size = size;
	}
	
}
