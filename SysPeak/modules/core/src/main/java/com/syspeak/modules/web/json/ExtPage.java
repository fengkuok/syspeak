package com.syspeak.modules.web.json;

import java.util.Map;

public class ExtPage<T> extends org.springside.modules.orm.Page<T>{
	private boolean success;
	
//	private List<> fields;
	
	private Map<String,Object> model;

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
