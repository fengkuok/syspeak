package com.syspeak.makereap.workflow.web.mvc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.syspeak.makereap.workflow.domain.logic.UserService;

@Controller
public class UserController {

	private UserService userService;

	@Autowired
	public void setUserService(UserService userService) {
		this.userService = userService;
	}
}
