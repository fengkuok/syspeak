package com.syspeak.makereap.common.web.controller;


/**
 * Spring MVC Controller基类
 *
 * @author JemiZhuu(周士淳)
 * @version 1.0
 * @company SysPeak (C) Copyright
 * @category BaseControllerImpl
 * @since 2011-9-14
 */
public class BaseControllerImpl implements BaseController {
    protected static final String CONTROLLER_FLAG = "controller";
    protected static final String PACKAGE_FLAG = "springmvc";
    protected static final int PAGE_SIZE = 20;
    protected static final String PAGE_BEAN = "page";
    protected static final String VIEW_SPLIT = "-";

    /**
     * 获取Controller默认的RequestMapping
     *
     * @return
     */
    public String getMappingBase() {
        String className = getClass().getName().toLowerCase();
        String mappingBase = className.replaceAll("[\\s\\S]+" + basePackage + '.', "");
        mappingBase = mappingBase.replaceAll(CONTROLLER_FLAG + "+[\\s\\S]*$", "");
        return mappingBase;
    }

    /**
     * 获取Controller默认的index视图名称
     *
     * @return
     */
    public String getIndexViewName() {
        String base = getMappingBase();
        String indexViewName = base + VIEW_SPLIT + INDEX;
        return indexViewName;
    }

    /**
     * 获取Controller默认的list视图名称
     *
     * @return
     */
    public String getListViewName() {
        String base = getMappingBase();
        String listViewName = base + VIEW_SPLIT + LIST;
        return listViewName;
    }

    /**
     * 获取Controller默认的input实体名称
     *
     * @return
     */
    public String getInputViewName() {
        String base = getMappingBase();
        String inputViewName = base + VIEW_SPLIT + INPUT;
        return inputViewName;
    }

    private String basePackage = PACKAGE_FLAG;

    public void setBasePackage(String basePackage) {
        this.basePackage = basePackage;
    }
}
