package com.test.caizq.demo.serviceImpl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.test.caizq.demo.dao.UserMapper;
import com.test.caizq.demo.entity.User;
import com.test.caizq.demo.service.UserService;

@Service
public class UserServiceImpl implements UserService{

	@Resource
	private UserMapper userMapper;

	@Override
	public User getUserByName(String username) {
		// TODO Auto-generated method stub
		return userMapper.getUserByName(username);
		
	}
	
	
	
}
