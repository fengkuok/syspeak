package com.syspeak.itboss.web.springmvc;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.syspeak.modules.web.springmvc.BaseControllerImpl;

/**
 * 系统管理首页Controller
 * @company SysPeak (C) Copyright
 * @category IndexController
 * @version 1.0
 * @since 2011-9-29
 * @author JemiZhuu(周士淳)
 */
@Controller
@RequestMapping("/index")
public class IndexController extends BaseControllerImpl {

	@RequestMapping
	public ModelAndView index(ModelAndView modelAndView) {
		modelAndView.setViewName("index");
		return modelAndView;
	}
}
