package com.syspeak.itboss.service;

import org.springframework.stereotype.Service;

import com.syspeak.itboss.dao.UserDao;
import com.syspeak.itboss.domain.User;
import com.syspeak.modules.service.BaseLongIdEntityServiceImpl;

/**
 * 
 * @company SysPeak (C) Copyright
 * @category UserService
 * @version 1.0
 * @since 2011-9-29
 * @author JemiZhuu(周士淳)
 */
@Service
public class UserService extends BaseLongIdEntityServiceImpl<User, UserDao> {

	/**
	 * 按登录用户名查找用户
	 * @param username
	 * @return
	 */
	public User findByUserName(String username) {
		return this.findUniqueBy("username", username);
	}
}
