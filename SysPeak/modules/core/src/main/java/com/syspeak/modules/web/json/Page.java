package com.syspeak.modules.web.json;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang.StringUtils;

public class Page<T> {

	// -- 公共变量 --//
	public static final String ASC = "asc";
	public static final String DESC = "desc";

	// -- 分页参数 --//
	/** 排序列名称 */
	private String sort;
	/** 排序方式(ASC/DESC) */
	private String dir;
	/** 起始记录数 */
	private int start;
	/** 最大记录数 */
	private int limit;
	/** 自动统计 */
	private boolean autoCount = true;

	// -- 返回结果 --//
	/** 结果集 */
	private List<T> result = new ArrayList<T>();
	/** 结果总数 */
	private Long totalCount;
	/** 是否成功 */
	private boolean success;
	/** 删除时ID串（1,2,3...） */

	// -- 传入参数 --//
	private String ids;
	/** 键值对List */
	public boolean isAutoCount() {
		return autoCount;
	}

	public void setAutoCount(boolean autoCount) {
		this.autoCount = autoCount;
	}

	public String getIds() {
		return ids;
	}

	public void setIds(String ids) {
		this.ids = ids;
	}

	public String getSort() {
		return sort;
	}

	public void setSort(String sort) {
		this.sort = sort;
	}

	public String getDir() {
		return dir;
	}

	public void setDir(String dir) {
		this.dir = dir;
	}

	public int getStart() {
		return start;
	}

	public void setStart(int start) {
		this.start = start;
	}

	public int getLimit() {
		return limit;
	}

	public void setLimit(int limit) {
		this.limit = limit;
	}

	public List<?> getResult() {
		return result;
	}

	public void setResult(List<T> result) {
		this.result = result;
	}

	public Long getTotalCount() {
		return totalCount;
	}

	public void setTotalCount(Long totalCount) {
		this.totalCount = totalCount;
	}

	public boolean isSuccess() {
		return success;
	}

	public void setSuccess(boolean success) {
		this.success = success;
	}

	/**
	 * 是否已设置排序字段,无默认值.
	 */
	public boolean isOrderBySetted() {
		return (StringUtils.isNotBlank(sort) && StringUtils
				.isNotBlank(dir));
	}
}
