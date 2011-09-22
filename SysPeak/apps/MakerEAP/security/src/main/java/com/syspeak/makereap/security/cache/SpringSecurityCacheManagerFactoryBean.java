package com.syspeak.makereap.security.cache;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.FactoryBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.security.core.userdetails.UserCache;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.util.Assert;

import com.syspeak.makereap.security.service.AuthenticationService;


public class SpringSecurityCacheManagerFactoryBean implements
		FactoryBean<SpringSecurityCacheManager>, InitializingBean {

	/**
     * logger.
     */
    private static Log logger = LogFactory.getLog(SpringSecurityCacheManagerFactoryBean.class);
    
	/**
	 * 缓存管理器.
	 */
	private SpringSecurityCacheManager springSecurityCacheManager;

	/**
	 * 授权服务.
	 */
	private AuthenticationService authenticationService;

	/**
	 * 用户缓存.
	 */
	private UserCache userCache = null;

	@Override
	public void afterPropertiesSet() throws Exception {
		logger.info("Initializing SpringSecurityCacheManager");
        Assert.notNull(userCache, "userCache should not be null");
      //  Assert.notNull(resourceCache, "resourceCache should not be null");
        Assert.notNull(authenticationService,"Authentication Service should not be null");

        //初始化缓存
        List<UserDetails> users = authenticationService.getUsers();
        
        for(UserDetails user : users){
        	 userCache.putUserInCache(user);
        }

//        for (Iterator iter = users.iterator(); iter.hasNext();) {
//            UserDetails user = (UserDetails) iter.next();
//            userCache.putUserInCache(user);
//        }
		System.out.println("com.syspeak.makereap.security.cache.SpringSecurityCacheManagerFactoryBean.afterPropertiesSet()");
	}

	@Override
	public SpringSecurityCacheManager getObject() throws Exception {
		return springSecurityCacheManager;
	}

	@Override
	public Class<?> getObjectType() {
		if (springSecurityCacheManager != null) {
			return springSecurityCacheManager.getClass();
		} else {
			return SpringSecurityCacheManager.class;
		}
	}

	@Override
	public boolean isSingleton() {
		return true;
	}

	// ---Setter and Getter

	public AuthenticationService getAuthenticationService() {
		return authenticationService;
	}

	public void setAuthenticationService(
			AuthenticationService authenticationService) {
		this.authenticationService = authenticationService;
	}

	public UserCache getUserCache() {
		return userCache;
	}

	public void setUserCache(UserCache userCache) {
		this.userCache = userCache;
	}

}
