package com.test.caizq.demo.controller;

import java.util.List;
import java.util.UUID;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.test.caizq.demo.entity.JsonResult;
import com.test.caizq.demo.entity.User;
import com.test.caizq.demo.serviceImpl.UserServiceImpl;
import com.test.caizq.demo.util.GenerateUtils;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/test")
@Api(value = "Swagger2在线接口文档")
public class TestController {

	private final static Logger logger = LoggerFactory.getLogger(TestController.class);
	@Resource
	private UserServiceImpl userServiceImpl;
	
	@RequestMapping("/log")
	public String testLog() {
		logger.debug("========debug级别===");
		logger.info("===info=====");
		logger.error("======error====");
		logger.warn("======warn==========");
		
		String str1 = "test1";
		String str2 = "test2";
		
		logger.info("====测试日志信息{}，{}",str1,str2);
		
		return "success";
	}
	
	@PostMapping("/form2")
	@ApiOperation(value = "获取用户信息")
	public JsonResult<User> getUser(@RequestBody User user) throws InterruptedException {
		
		logger.info(user.getUsername()+", "+user.getPassword());
		JsonResult<User> result = new JsonResult<>(user);
		Thread.sleep(2000);
		return result;
		
	}
	
	@GetMapping("/exception") //测试空指针
	public JsonResult<User> testException(){
	
		User user = null;
		String name = user.getUsername();
		JsonResult<User> result = new JsonResult<User>("200",name);
		return result;
		
	}
	
	@GetMapping("/testMybatis/{username}")
	public User testMybatis(@PathVariable String username) {
		
		return userServiceImpl.getUserByName(username);
		
	}
	
	@GetMapping("/testMybatis/getAllData")
	public List<User> testMybatis() {
		
		return userServiceImpl.getAllUsers();
		
	}
	/**
	 * 新增一条username不重复的记录，参数随机生成
	 * 
	 */
	@GetMapping("/testMybatis/addUser")
	public JsonResult<User> testAddUser() {
		
		int id = UUID.randomUUID().toString().hashCode();
		if(id<0) {id = -id;}
		String username = GenerateUtils.getRandomString(8);
		String password = GenerateUtils.getRandomString(16);
		
		
		//判断用户username是否已存在
		User originUser = userServiceImpl.getUserByName(username);
		if(originUser!=null) {
           return new JsonResult<User>("200","数据已存在",originUser);
		}
		
		User user = new User(Integer.toString(id),username,password);
		userServiceImpl.addUser(user);
		return new JsonResult<User>("200","写入成功",user);
	}
}
