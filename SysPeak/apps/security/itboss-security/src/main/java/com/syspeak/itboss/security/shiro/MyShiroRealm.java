package com.syspeak.itboss.security.shiro;



import java.util.Collection;

import com.syspeak.itboss.domain.Role;
import com.syspeak.itboss.domain.User;
import com.syspeak.itboss.service.impl.UserServiceImpl;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.ExpiredCredentialsException;
import org.apache.shiro.authc.LockedAccountException;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.cache.Cache;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.subject.SimplePrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;


/**
 * Shiro Realm 实现
 *
 */
public class MyShiroRealm extends AuthorizingRealm{

	/**
	 * 授权信息
	 */
	protected AuthorizationInfo doGetAuthorizationInfo(
			PrincipalCollection principals) {

        String loginName = (String) principals.fromRealm(getName()).iterator().next();
		User user = userService.findByUserName(loginName);
		if (user != null) {
			SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
			for (Role role : user.getRoles()) {
				info.addStringPermissions(role.getRescPermissions());
			}
			return info;
		} else {
			return null;
		}
	}

	/**
	 * 认证信息
	 */
	protected AuthenticationInfo doGetAuthenticationInfo(
			AuthenticationToken authcToken ) throws AuthenticationException {
		UsernamePasswordToken token = (UsernamePasswordToken) authcToken;
		String accountName = token.getUsername();

		if( accountName != null && !"".equals(accountName) ){

             User user = userService.findUniqueBy("username", token.getUsername());
			if( user != null ){
				if( !user.isEnabled() )
					throw new LockedAccountException("用户账号已禁用！");

				if( !user.isExpired() )
					throw new ExpiredCredentialsException("用户账号已过期！");

				return new SimpleAuthenticationInfo(
						user.getUsername(),user.getPassword(), getName() );
			}
		}

		return null;
	}

    /**
	 * 更新用户授权信息缓存.
	 */
	public void clearCachedAuthorizationInfo(String principal) {
		SimplePrincipalCollection principals = new SimplePrincipalCollection(principal, getName());
		clearCachedAuthorizationInfo(principals);
	}

	/**
	 * 清除所有用户授权信息缓存.
	 */
	public void clearAllCachedAuthorizationInfo() {
		Cache<Object, AuthorizationInfo> cache = getAuthorizationCache();
		if (cache != null) {
			for (Object key : cache.keys()) {
				cache.remove(key);
			}
		}
	}

  private UserServiceImpl userService;

	@Autowired
	public void setUserService(UserServiceImpl userService) {
		this.userService = userService;
	}
}
