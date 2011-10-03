package com.syspeak.oa.service;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.RowBounds;

import com.syspeak.oa.domain.User;

public interface UserService {
	void addUser(User user);

	void modifyUser(User user);

	void deleteUser(User user);

	List<User> listUsers(Map<String, Object> params, RowBounds rowBounds);
}
