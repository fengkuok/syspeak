package com.syspeak.modules.web.springmvc;

import org.springframework.web.servlet.ModelAndView;
import org.springside.modules.orm.PageRequest;

/**
 * Spring MVC Controller基类
 * @company SysPeak (C) Copyright
 * @category BaseControllerImpl
 * @version 1.0
 * @since 2011-9-14
 * @author JemiZhuu(周士淳)
 */
public class BaseControllerImpl implements BaseController {
	protected static final String CONTROLLER_FLAG = "controller";
	protected static final String PACKAGE_FLAG = "springmvc";
	protected static final int PAGE_SIZE = 20;
	protected static final String PAGE_BEAN = "page";
	protected static final String VIEW_SPLIT = "-";

	/**
	 * 根据视图名称准备ModelAndView
	 * @param viewName
	 * @return
	 */
	protected ModelAndView prepareModelAndView(String viewName) {
		ModelAndView modelAndView = new ModelAndView(viewName);
		return modelAndView;
	}

	/**
	 * 准备index页面ModelAndView
	 * @return
	 */
	protected ModelAndView prepareIndexModelAndView() {
		return prepareModelAndView(getIndexViewName());
	}

	/**
	 * 准备list页面ModelAndView
	 * @return
	 */
	protected ModelAndView prepareListModelAndView() {
		return prepareModelAndView(getListViewName());
	}

	/**
	 * 准备分页查询请求Request对象
	 * @param pageRequest
	 * @return
	 */
	protected PageRequest preparePageRequest(PageRequest pageRequest) {
		if (pageRequest == null) {
			pageRequest = new PageRequest(1, PAGE_SIZE);
		}
		return pageRequest;
	}

	/**
	 * 获取Controller默认的RequestMapping
	 * @return
	 */
	protected String getMappingBase() {
		String className = getClass().getName().toLowerCase();
		String mappingBase = className.replaceAll("[\\s\\S]+" + basePackage + '.', "");
		mappingBase = mappingBase.replaceAll(CONTROLLER_FLAG + "+[\\s\\S]*$", "");
		mappingBase = mappingBase.replaceAll("[.]", "/");
		System.out.println(mappingBase);
		return mappingBase;
	}

	/**
	 * 获取Controller默认的index视图名称
	 * @return
	 */
	protected String getIndexViewName() {
		String base = getMappingBase();
		String indexViewName = base + VIEW_SPLIT + BaseController.INDEX;
		return indexViewName;
	}

	/**
	 * 获取Controller默认的list视图名称
	 * @return
	 */
	protected String getListViewName() {
		String base = getMappingBase();
		String listViewName = base + VIEW_SPLIT + BaseController.LIST;
		return listViewName;
	}

	/**
	 * 获取Controller默认的input实体名称
	 * @return
	 */
	protected String getInputViewName() {
		String base = getMappingBase();
		String inputViewName = base + VIEW_SPLIT + BaseController.INPUT;
		return inputViewName;
	}

	private String basePackage = PACKAGE_FLAG;

	public void setBasePackage(String basePackage) {
		this.basePackage = basePackage;
	}
}
