package com.syspeak.oa.util;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;

import com.syspeak.oa.dao.UserMapper;
import com.syspeak.oa.domain.User;


public class MyRealm extends AuthorizingRealm {

	@Autowired
	private UserMapper userMapper;

	// @Autowired
	// private RoleMapper roleMapper;

	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
		// String username = (String) getAvailablePrincipal(principals);
		// if (username != null) {
		// List<Role> roles = userMapper.getUserRoles(new User(username));
		// if (roles.size() > 0) {
		// SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
		// for (Role role : roles) {
		// info.addRole(role.getRolename());
		// info.addStringPermissions(roleMapper.getPermissions(role));
		// }
		// return info;
		// }
		// }
		return null;
	}

	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
		UsernamePasswordToken upToken = (UsernamePasswordToken) token;
		String username = upToken.getUsername();
		if (username != null && !"".equals(username)) {
			User user = userMapper.getUser(username);
			if (user != null) {
				SimpleAuthenticationInfo info = new SimpleAuthenticationInfo(user.getUsername(), user.getPassword(), getName());
				return info;
			}
		}
		return null;
	}
}
