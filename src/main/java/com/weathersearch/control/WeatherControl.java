package com.weathersearch.control;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.weathersearch.HttpUtil2;
import com.weathersearch.entity.User;
import com.weathersearch.service.UserService;

@RestController
@RequestMapping("/weather")
public class WeatherControl {
	
	private String url_now = "https://api.seniverse.com/v3/weather/now.json?key=8xpdyjgfcizdqyuc&location=LOCATION";
	private String url_daily = "https://api.seniverse.com/v3/weather/daily.json?key=8xpdyjgfcizdqyuc&location=LOCATION&start=0&days=3";
	private String url_life = "https://api.seniverse.com/v3/life/suggestion.json?key=8xpdyjgfcizdqyuc&location=LOCATION";

	/**
	 * 根据城市获取实时天气
	 * 
	 * @param location
	 * @return
	 */
	@GetMapping("/now/{location}")
	public String now(@PathVariable("location") String location) {
		try {
			location = URLEncoder.encode(location, "utf-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		String url = url_now.replace("LOCATION", location);
		String resp = HttpUtil2.getRequest(url, "utf-8");
		return resp;
	}

	/**
	 * 根据城市查询未来3天天气
	 * 
	 * @param location
	 * @return
	 */
	@GetMapping("/daily/{location}")
	public String daily(@PathVariable("location") String location) {
		try {
			location = URLEncoder.encode(location, "utf-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		String url = url_daily.replace("LOCATION", location);
		String resp = HttpUtil2.getRequest(url, "utf-8");
		return resp;
	}

	/**
	 * 根据城市查询当天生活指数
	 * 
	 * @param location
	 * @return
	 */
	@GetMapping("/life/{location}")
	public String life(@PathVariable("location") String location) {
		try {
			location = URLEncoder.encode(location, "utf-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		String url = url_life.replace("LOCATION", location);
		String resp = HttpUtil2.getRequest(url, "utf-8");
		return resp;
	}
	
	@Autowired
	private UserService userService;
	
	@GetMapping("/register")
	public User register(@RequestParam("name") String name,@RequestParam("pass") String pass) {
		User register = userService.register(name, pass);
		return register;
	}
	
	@GetMapping("/userList/{page}")
	public Page<User> getUserList(@PathVariable("page") Integer page) {
		Page<User> list = userService.getUserList(page);
		return list;
	}

}
