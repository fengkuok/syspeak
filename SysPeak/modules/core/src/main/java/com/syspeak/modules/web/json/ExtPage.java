package com.syspeak.modules.web.json;

import java.util.Map;

import org.springside.modules.orm.Page;
import org.springside.modules.orm.PageRequest;

public class ExtPage<T> extends Page<T> {
	private boolean success;

	public ExtPage() {
		super();
	}

	public ExtPage(PageRequest request) {
		super(request);
		this.orderBy = (this.orderBy == null) ? "" : this.orderBy;
		this.orderDir = (this.orderDir == null) ? "" : this.orderDir;
	}

	//	private List<> fields;

	private Map<String, Object> model;

	public boolean isSuccess() {
		return success;
	}

	public void setSuccess(boolean success) {
		this.success = success;
	}

	public Map<String, Object> getModel() {
		return model;
	}

	public void setModel(Map<String, Object> model) {
		this.model = model;
	}

}
