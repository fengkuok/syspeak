package com.syspeak.modules.web.extjs;

import java.util.List;

import org.springside.modules.orm.PageRequest;

/**
 * 针对ExtJS进行封装的分页Request类
 * @company SysPeak (C) Copyright
 * @category ExtPageRequest
 * @version 1.0
 * @since 2011-10-12
 * @author JemiZhuu(周士淳)
 */
public class ExtPageRequest extends PageRequest {

	/**
	 * ExtJS page参数
	 * @param pageNo
	 */
	public void setPage(int pageNo) {
		this.pageNo = pageNo;
	}

	/**
	 * ExtJS limit参数
	 * @param limit
	 */
	public void setLimit(int limit) {
		this.pageSize = limit;
	}

	/**
	 * ExtJS sort参数
	 * @param sort
	 */
	public void setSort(List<String> sort) {
		System.out.println("Set Sort(String): " + sort);
	}
}
