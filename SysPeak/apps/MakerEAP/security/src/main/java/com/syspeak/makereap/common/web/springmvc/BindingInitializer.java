package com.syspeak.makereap.common.web.springmvc;

import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.support.WebBindingInitializer;
import org.springframework.web.context.request.WebRequest;

import java.util.Date;

/**
 * 数据绑定初始化类
 */
public class BindingInitializer implements WebBindingInitializer {
    /**
     * 初始化数据绑定
     */
    public void initBinder(WebDataBinder binder, WebRequest request) {
        binder.registerCustomEditor(Date.class, new DateTypeEditor());
    }
}
