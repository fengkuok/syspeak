package com.syspeak.oa.web.controller;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping
public class LoginController {

	@RequestMapping("/login")
	public String login() {
		return "login";
	}

	@RequestMapping("/doLogin")
	public String doLogin() {
		UsernamePasswordToken token = new UsernamePasswordToken("admin", "111111");
		try {
			SecurityUtils.getSubject().login(token);
			return "/index";
		} catch (AuthenticationException e) {
			e.printStackTrace();
			return "login";
		}
	}

	@RequestMapping("/logout")
	public String logout() {
		SecurityUtils.getSubject().logout();
		return "login";
	}

}
