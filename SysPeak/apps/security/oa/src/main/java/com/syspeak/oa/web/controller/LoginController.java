package com.syspeak.oa.web.controller;

import java.util.List;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.syspeak.oa.domain.Menu;
import com.syspeak.oa.service.MenuService;

@Controller
@RequestMapping
public class LoginController {

	@Autowired
	private MenuService menuService;

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

	@RequestMapping("/index")
	public void index() {

	}

	@RequestMapping("/listMenus")
	@ResponseBody
	public List<Menu> listMenus() {
		return menuService.listMenus(1);
	}
}
