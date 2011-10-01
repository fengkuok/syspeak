package com.syspeak.itboss.security;



import java.io.IOException;

import javax.annotation.Resource;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.syspeak.itboss.security.shiro.SecurityUtil;
import net.sf.ehcache.Cache;

import org.springframework.stereotype.Component;
import org.springframework.web.filter.GenericFilterBean;



@Component( "sessionInvalidateFilter" )
public class SessionInvalidateFilter extends GenericFilterBean{

	/**
	 * 用于存放Session强制失效的用户名
	 */
	@Resource( name="sessionInvalidateUserCache" )
	private Cache cache;

	private String logoutUrl = "/logout";

	public void setCache(Cache cache) {
		this.cache = cache;
	}

	public void setLogoutUrl(String logoutUrl) {
		this.logoutUrl = logoutUrl;
	}

	@Override
	public void doFilter(ServletRequest req, ServletResponse rsp,
			FilterChain chain) throws IOException, ServletException {
		HttpServletRequest request = (HttpServletRequest)req;
		HttpServletResponse response = (HttpServletResponse)rsp;
		if( cache != null ){
			String username = SecurityUtil.getPrincipal();
			if( cache.get( username ) != null ){
				cache.remove( username );
				request.getSession().setAttribute( "error_messages", "账号["+username+"]已被禁止使用！");
				response.sendRedirect( request.getContextPath() + logoutUrl);
			}
		}

		chain.doFilter(req, rsp);
	}

}
