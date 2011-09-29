package com.syspeak.itboss.web.springmvc;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.syspeak.modules.web.springmvc.BaseControllerImpl;

/**
 * 系统登录Controller
 * @company SysPeak (C) Copyright
 * @category LoginController
 * @version 1.0
 * @since 2011-9-29
 * @author JemiZhuu(周士淳)
 */
@Controller
@RequestMapping("/login")
public class LoginController extends BaseControllerImpl {

	@RequestMapping
	public ModelAndView index(ModelAndView modelAndView) {
		modelAndView.setViewName("login");
		return modelAndView;
	}

	@RequestMapping(method = RequestMethod.POST)
	public ModelAndView login(ModelAndView modelAndView) {
		return index(modelAndView);
	}
}
