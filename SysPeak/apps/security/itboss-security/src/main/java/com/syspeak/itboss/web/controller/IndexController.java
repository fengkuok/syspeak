package com.syspeak.itboss.web.controller;

import com.syspeak.modules.web.springmvc.BaseControllerImpl;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 * 系统管理首页Controller
 *
 * @author JemiZhuu(周士淳)
 * @version 1.0
 * @company SysPeak (C) Copyright
 * @category IndexController
 * @since 2011-9-29
 */
@Controller

public class IndexController extends BaseControllerImpl {

    @RequestMapping(value = "index", method = {RequestMethod.GET})
    public ModelAndView index(ModelAndView modelAndView) {
        modelAndView.setViewName("index");
        return modelAndView;
    }

    @RequestMapping(value = "top", method = {RequestMethod.GET})
    public ModelAndView top(ModelAndView modelAndView) {

        modelAndView.setViewName("top");
        return modelAndView;
    }

    @RequestMapping(value = "main", method = {RequestMethod.GET})
    public ModelAndView main(ModelAndView modelAndView) {

        modelAndView.setViewName("main");
        return modelAndView;
    }

    @RequestMapping(value = "left", method = {RequestMethod.GET})
    public ModelAndView left(ModelAndView modelAndView) {

        modelAndView.setViewName("left");
        return modelAndView;
    }

    @RequestMapping(value = "right", method = {RequestMethod.GET})
    public ModelAndView right(ModelAndView modelAndView) {

        modelAndView.setViewName("right");
        return modelAndView;
    }


}
