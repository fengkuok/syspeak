package com.syspeak.makereap.security.api.cache;

import com.syspeak.makereap.security.api.resource.ResourceDetails;

public interface SecurityCacheManager<U> {
	/**
	 * 根据用户名获得用户信息.
	 * 
	 * @param username
	 * @return U 在spring security中可以为UserDetails
	 * 			 在Shiro中为XXX
	 */
	U getUserFromCache(String username);

	ResourceDetails getResourceFromCache(String resourceStr);
	
	void removeUser(String username);
	
	void removeResource(String resourceStr);
	
	
}
