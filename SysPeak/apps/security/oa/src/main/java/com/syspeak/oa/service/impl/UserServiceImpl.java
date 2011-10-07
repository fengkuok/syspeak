package com.syspeak.oa.service.impl;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.RowBounds;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.syspeak.oa.dao.UserMapper;
import com.syspeak.oa.domain.User;
import com.syspeak.oa.service.UserService;

@Service
@Transactional
public class UserServiceImpl implements UserService {

	@Autowired
	private UserMapper userMapper;

	@Transactional
	public void addUser(User user) {
		userMapper.addUser(user);
	}

	public void modifyUser(User user) {
		// TODO Auto-generated method stub

	}

	public void deleteUser(User user) {
		// TODO Auto-generated method stub

	}

	public User getUser(String username) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<User> listUsers(Map<String, Object> params, RowBounds rowBounds) {
		return userMapper.listUsers(params, rowBounds);
	}

	public int getTotal() {
		return userMapper.getTotal();
	}

	@Override
	public boolean userExisted(String username) {
		if (userMapper.getUserserCountByUsername(username) >= 1)
			return true;
		return false;
	}

	@Override
	@Transactional
	public void deleteUsers(List<User> users) {
		userMapper.deleteUsers(users);
	}

}
