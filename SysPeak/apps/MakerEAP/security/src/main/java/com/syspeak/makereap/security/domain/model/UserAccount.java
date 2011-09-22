package com.syspeak.makereap.security.domain.model;

import java.util.List;

public interface UserAccount{
	
	public String getUsername();
	
	public String getPassword();
	
	public boolean isEnabled();
	
	public List<? extends RoleDetail> getRoles();
}
