package com.syspeak.oa.web.controller;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping
public class LoginController {

	@RequestMapping("/login")
	public void login() {
		UsernamePasswordToken token = new UsernamePasswordToken("admin", "111111");
		SecurityUtils.getSubject().login(token);

	}
}
