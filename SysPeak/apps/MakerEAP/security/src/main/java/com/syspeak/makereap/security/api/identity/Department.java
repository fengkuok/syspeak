package com.syspeak.makereap.security.api.identity;

import java.util.List;

public interface Department {
	public Long getId();
	
	public String getName();
	
	public String getDescription();
	
	
	//~~~~~~~~~~~
	/**
	 * 上级部门
	 * @return
	 */
	public Department getParent();
	
	/**
	 * 下级部门
	 * @return
	 */
	public List<Department> getChilds();
	
	
}
