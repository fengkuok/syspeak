package com.syspeak.makereap.security.domain.logic;

import java.util.List;

import com.syspeak.makereap.security.domain.model.UserAccount;


public interface UserAccountService<T extends UserAccount> {
	public static final String NAME = "userAccountService";
	public static final String GET_USER_ACCOUNT_LIST = "getUserAccountList";
	
	public T findUserAccount(Long id);
	
	public List<T> getUserAccountList();
	
	public void saveOrUpdateUserAccount(T entity);
	
	public void removeUserAccount(Long id);
	
	public void removeUserAccount(String ids);
}
