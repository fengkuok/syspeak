package com.syspeak.itboss.security.shiro;


import org.apache.shiro.authc.AuthenticationException;


/**
 * SHIRO验证码异常
 *
 */
public class ShiroBadCaptchaException extends AuthenticationException
	implements BadCaptchaException{

	private static final long serialVersionUID = -4987144327107616457L;

	public ShiroBadCaptchaException() {
		super();
	}

	public ShiroBadCaptchaException(String message, Throwable cause) {
		super(message, cause);
	}

	public ShiroBadCaptchaException(String message) {
		super(message);
	}

	public ShiroBadCaptchaException(Throwable cause) {
		super(cause);
	}

}
