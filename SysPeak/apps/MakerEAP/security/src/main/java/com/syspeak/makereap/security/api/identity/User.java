package com.syspeak.makereap.security.api.identity;

import java.util.Date;
import java.util.List;

/**
 * 
 * @author GuoFeng
 * @version 0.1
 *
 */
public interface User {
	 
	 public Long getId();
	 
	 public String getUsername();
	 
	 public void setUsername();
	 
	 public String getPassword();
	 
	 public void setPassword();
	 
	 public String getRealName();
	 
	 public void setRealName();
	 
	 public String getBusinessEmail();
	 
	 public void setBusinessEmail();
	 
	 public Boolean isEnabled();
	 
	 public Date getCreateTime();
	 
	 public String getDescription();
	 
	 public void setDescription(String description); 
	 
	 
	 //~~~~~~relation
	 
	 Department getDepartment();
	 
	 public List<Role> getRoles();
	 
	 // future road map
	 public List<Group> getGroups();
	 


}
