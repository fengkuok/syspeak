package com.syspeak.makereap.workflow.web.mvc.explorer;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springside.modules.orm.PageRequest;
import org.springside.modules.orm.PropertyFilter;

import com.syspeak.makereap.workflow.domain.logic.UserService;

@Controller
@RequestMapping("/user")
public class UserController {

	private UserService userService;

	@Autowired
	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	@RequestMapping("/list")
	@ResponseBody
	public Map<String, Object> listUsers(@RequestParam(value = "page") int pageNo, @RequestParam(value = "limit") int pageSize) {
		System.out.println(pageSize);
		PageRequest pageRequest = new PageRequest();
		pageRequest.setPageNo(pageNo);
		pageRequest.setPageSize(pageSize);
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("users", userService.findPage(pageRequest, new ArrayList<PropertyFilter>()).getResult());
		map.put("total", userService.getAll().size());
		return map;
	}
}
