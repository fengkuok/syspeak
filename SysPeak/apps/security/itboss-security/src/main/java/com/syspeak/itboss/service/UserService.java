package com.syspeak.itboss.service;

import com.syspeak.itboss.domain.User;

/**
 * 
 * @company SysPeak (C) Copyright
 * @category UserService
 * @version 1.0
 * @since 2011-9-29
 * @author JemiZhuu(周士淳)
 */
public interface UserService {

	/**
	 * 按登录用户名查找用户
	 * 
	 * @param username
	 * @return
	 */
	public User findByUserName(String username);
}
