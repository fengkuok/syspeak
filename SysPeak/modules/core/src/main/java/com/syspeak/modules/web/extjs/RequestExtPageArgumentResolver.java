package com.syspeak.modules.web.extjs;

import org.springframework.core.MethodParameter;
import org.springframework.web.bind.support.WebDataBinderFactory;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.ModelAndViewContainer;

import com.syspeak.modules.utils.data.DataValidateUtils;

/**
 * 针对ExtJS的分页Request请求对象参数解析器
 * @company SysPeak (C) Copyright
 * @category RequestExtPageArgumentResolver
 * @version 1.0
 * @since 2011-10-12
 * @author JemiZhuu(周士淳)
 */
public class RequestExtPageArgumentResolver implements HandlerMethodArgumentResolver {

	private static final String PROPERTY = "property:";
	private static final String DIRECTION = "direction:";

	@Override
	public boolean supportsParameter(MethodParameter parameter) {
		return parameter.getParameterAnnotation(RequestExtPageArgument.class) != null;
	}

	@Override
	public Object resolveArgument(MethodParameter parameter, ModelAndViewContainer mavContainer,
			NativeWebRequest webRequest, WebDataBinderFactory binderFactory) throws Exception {
		RequestExtPageArgument attr = parameter.getParameterAnnotation(RequestExtPageArgument.class);
		String pageName = attr.value();
		pageName = (DataValidateUtils.isBlank(pageName)) ? "" : pageName + ".";
		String pageNoParam = pageName + attr.pageNoParam();
		String pageSizeParam = pageName + attr.pageSizeParam();
		ExtPageRequest pageRequest = new ExtPageRequest();
		String pageNo = webRequest.getParameter(pageNoParam);
		//设置分页序号
		if (DataValidateUtils.isIntegerString(pageNo)) {
			pageRequest.setPageNo(Integer.parseInt(pageNo));
		}
		String pageSize = webRequest.getParameter(pageSizeParam);
		//设置分页大小
		if (DataValidateUtils.isIntegerString(pageSize)) {
			pageRequest.setPageSize(Integer.parseInt(pageSize));
		}
		//设置分页属性排序
		String sortParam = pageName + attr.sortParam();
		String sort = webRequest.getParameter(sortParam);
		StringBuilder orderBy = new StringBuilder();
		StringBuilder orderDir = new StringBuilder();
		if (!DataValidateUtils.isBlank(sort)) {
			sort = sort.replaceAll("[\\[{\"'}\\]]", "");
			String[] orders = sort.split(",");
			for (String order : orders) {
				int index = -1;
				if ((index = order.indexOf(PROPERTY)) != -1) {
					index = index + PROPERTY.length();
					String propertyName = order.substring(index);
					if (DataValidateUtils.isBlank(propertyName)) {
						continue;
					}
					if (orderBy.length() > 0) {
						orderBy.append(",");
					}
					orderBy.append(propertyName);
				} else if ((index = order.indexOf(DIRECTION)) != -1) {
					index = DIRECTION.length();
					String direction = order.substring(index);
					if (DataValidateUtils.isBlank(direction)) {
						continue;
					}
					if (orderDir.length() > 0) {
						orderDir.append(",");
					}
					orderDir.append(direction);
				}
			}
		}
		pageRequest.setOrderBy(orderBy.toString());
		pageRequest.setOrderDir(orderDir.toString());
		return pageRequest;
	}
}
