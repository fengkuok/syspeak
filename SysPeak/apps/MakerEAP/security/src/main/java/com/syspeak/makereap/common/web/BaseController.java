package com.syspeak.makereap.common.web;

/**
 * Spring MVC Controller基类接口
 * @company SysPeak (C) Copyright
 * @category BaseController
 * @version 1.0
 * @since 2011-9-14
 * @author JemiZhuu(周士淳)
 */
public interface BaseController {
	public static final String INDEX = "index";
	public static final String LIST = "list";
	public static final String INPUT = "input";

	/**
	 * 获取Controller默认的RequestMapping
	 * @return
	 */
	abstract String getMappingBase();

	/**
	 * 获取Controller默认的index视图名称
	 * @return
	 */
	abstract String getIndexViewName();

	/**
	 * 获取Controller默认的list视图名称
	 * @return
	 */
	abstract String getListViewName();

	/**
	 * 获取Controller默认的input实体名称
	 * @return
	 */
	abstract String getInputViewName();
}
