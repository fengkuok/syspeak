package com.syspeak.modules.web.springmvc;


import org.springframework.web.servlet.view.freemarker.FreeMarkerView;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

/**
 * 扩展spring的FreemarkerView，加上base属性。
 * <p/>
 * 支持jsp标签，Application、Session、Request、RequestParameters属性
 */
public class RichFreeMarkerView extends FreeMarkerView {
    /**
     * 部署路径属性名称
     */
    public static final String CONTEXT_PATH = "ctx";

    /**
     * 在model中增加部署路径ctx，方便处理部署路径问题。
     */
    @SuppressWarnings("unchecked")
    protected void exposeHelpers(Map model, HttpServletRequest request)
            throws Exception {
        super.exposeHelpers(model, request);
        model.put(CONTEXT_PATH, request.getContextPath());
    }
}