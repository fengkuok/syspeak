package com.syspeak.makereap.security.userdetails;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.context.support.MessageSourceAccessor;
import org.springframework.security.core.SpringSecurityMessageSource;
import org.springframework.security.core.userdetails.UserCache;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

public class InCacheDaoImpl implements UserDetailsService {

	/** * logger. */
	private static Log logger = LogFactory.getLog(InCacheDaoImpl.class);

	/** * 国际化. */
	protected MessageSourceAccessor messages = SpringSecurityMessageSource
			.getAccessor();

	private UserCache userCache;

	@Override
	public UserDetails loadUserByUsername(String username) {
		logger.debug(username);

		UserDetails ud = userCache.getUserFromCache(username);

		logger.debug(ud);

		if (ud != null) {
			return ud;
		} else {
			throw new UsernameNotFoundException(messages.getMessage(
					"InCacheDaoImpl.notFound", new Object[] { username },
					"Username {0} not found"), username);
		}
	}

	// --- Setter and Getter

	public void setUserCache(UserCache userCache) {
		this.userCache = userCache;
	}

}
