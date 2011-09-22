package com.syspeak.makereap.security;

import java.util.List;

import org.springframework.security.core.authority.GrantedAuthorityImpl;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;

/**
 * 用户信息建造器.
 * 
 * @author Lingo 2.x
 * @author GuoFeng 3.x
 */
public class UserDetailsBuilder {
	protected UserDetailsBuilder() {
	}

	/**
	 * 使用参数生成一个用户对象.
	 */
	public static UserDetails createUser(String username, String password,
			boolean enabled, List<GrantedAuthorityImpl> authorities) {
		return new User(username, password, enabled, true, true, true,
				authorities);
	}
}
