package com.syspeak.makereap.system.security.spring;


import com.syspeak.makereap.system.security.service.BadCaptchaException;
import org.springframework.security.authentication.AuthenticationServiceException;


/**
 * Spring Security 验证码异常

 */
public class SecurityBadCaptchaException extends AuthenticationServiceException
	implements BadCaptchaException {

	private static final long serialVersionUID = 3719616463845582702L;

	public SecurityBadCaptchaException(String msg, Throwable t) {
		super(msg, t);
	}

	public SecurityBadCaptchaException(String msg) {
		super(msg);
	}

}
