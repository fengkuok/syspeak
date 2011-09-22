package com.syspeak.makereap.security.service;

import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.util.ArrayList;
import java.util.List;

import org.springframework.security.core.authority.GrantedAuthorityImpl;
import org.springframework.security.core.userdetails.UserDetails;

import com.syspeak.makereap.security.UserDetailsBuilder;
import com.syspeak.makereap.security.domain.logic.UserAccountService;
import com.syspeak.makereap.security.domain.model.RoleDetail;
import com.syspeak.makereap.security.domain.model.UserAccount;


public class HibernateAuthenticationService implements AuthenticationService {

	private String rolePrefix;

//	@SuppressWarnings("rawtypes")
//	@Resource(name = UserAccountService.NAME)
//	private UserAccountService accountService;
	
	private List<UserAccountService> accountServiceList;
	private List<UserAccount> userAccounts = null;
	
	public HibernateAuthenticationService() {
		
	}
	
	static {
	}

	@Override
	public List<UserDetails> getUsers() {

		@SuppressWarnings("unchecked")
		List<UserAccount> accounts = null;//accountService.getUserAccountList();

		List<UserDetails> authAccounts = new ArrayList<UserDetails>();
		System.out.println(accounts.size());
		for (UserAccount account : accounts) {
			UserDetails ud = UserDetailsBuilder.createUser(account.getUsername(),
					account.getPassword(), account.isEnabled(),getAuthsByUserAccount(account));
			authAccounts.add(ud);
		}

		return authAccounts;
	}
	
	private void initUserAccounts() {
		//PropertyDescriptor[] ps = Introspector.getBeanInfo(bean.getClass()).getPropertyDescriptors();
	}
	
	
	/**
	 *  通过账户Account获取授权
	 * @param account 账户
	 * @return
	 */
	private List<GrantedAuthorityImpl> getAuthsByUserAccount(UserAccount account){
		List<GrantedAuthorityImpl> list = new ArrayList<GrantedAuthorityImpl>();
		
		for(RoleDetail roleDetail : account.getRoles()){
			String roleName = roleDetail.getName();//this.rolePrefix + 
			GrantedAuthorityImpl authority = new GrantedAuthorityImpl(roleName);
			list.add(authority);
		}
		return list;
	}
	
	
}
