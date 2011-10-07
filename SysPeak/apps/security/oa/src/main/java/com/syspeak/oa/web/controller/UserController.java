package com.syspeak.oa.web.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.ibatis.session.RowBounds;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.syspeak.oa.domain.User;
import com.syspeak.oa.service.UserService;

@Controller
@RequestMapping("/user")
public class UserController {

	@Autowired
	private UserService userService;

	@RequestMapping("/view")
	public void view() {
	}

	@RequestMapping("/list")
	@ResponseBody
	public Map<String, Object> list(@RequestParam("page") int page, @RequestParam("pagesize") int limit, Map<String, Object> map) {
		RowBounds rowBounds = new RowBounds((page - 1) * limit, limit);
		map.put("Rows", userService.listUsers(null, rowBounds));
		map.put("Total", userService.getTotal());
		return map;
	}

	@RequestMapping("/add")
	public void add() {
	}

	@RequestMapping("/userExisted")
	@ResponseBody
	public boolean userExisted(String username) {
		return userService.userExisted(username);
	}

	@RequestMapping("/doAdd")
	@ResponseBody
	public Map<String, Object> doAdd(User user, Map<String, Object> map) {
		map.clear();
		user.setCreateDate(new Date());
		user.setPassword("111111");
		try {
			userService.addUser(user);
			map.put("success", true);
		} catch (Exception e) {
			map.put("success", false);
		}
		return map;
	}

	@RequestMapping("/delete")
	@ResponseBody
	public Map<String, Object> delete(HttpServletRequest request, Map<String, Object> map) {
		List<User> users = new ArrayList<User>();
		String[] ids = request.getParameterValues("id");
		for (int i = 0; i < ids.length; i++) {
			users.add(new User(Integer.parseInt(ids[i])));
		}
		map.clear();
		try {
			userService.deleteUsers(users);
			map.put("success", true);
		} catch (Exception e) {
			e.printStackTrace();
			map.put("success", false);
		}
		return map;
	}
}
