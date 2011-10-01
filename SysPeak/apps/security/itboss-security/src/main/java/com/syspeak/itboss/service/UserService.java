package com.syspeak.itboss.service;

import com.syspeak.itboss.domain.User;

public interface UserService {

	/**
	 * 按登录用户名查找用户
	 *
	 * @param username
	 * @return
	 */
	public User findByUserName(String username) ;
}
