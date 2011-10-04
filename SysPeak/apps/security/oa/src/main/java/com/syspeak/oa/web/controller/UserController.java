package com.syspeak.oa.web.controller;

import java.util.Map;

import org.apache.ibatis.session.RowBounds;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

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
}
