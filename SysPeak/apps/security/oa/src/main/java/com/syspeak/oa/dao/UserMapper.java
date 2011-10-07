package com.syspeak.oa.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.RowBounds;
import org.springframework.stereotype.Component;

import com.syspeak.oa.domain.User;

@Component
public interface UserMapper {

	void addUser(User user);

	void modifyUser(User user);

	void deleteUser(User user);

	void deleteUsers(List<User> users);

	User getUser(String username);

	List<User> listUsers(Map<String, Object> params, RowBounds rowBounds);

	int getTotal();

	public int getUserserCountByUsername(String username);
}
