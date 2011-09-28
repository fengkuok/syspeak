package com.syspeak.makereap.system.security.service;

import javax.servlet.http.HttpServletRequest;

import org.apache.shiro.SecurityUtils;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;

import com.syspeak.makereap.common.web.SessionKey;

public class SecurityUtil {

	/**
	 * 显示验证码容忍次数（登录失败N次显示验证码）
	 */
	public final static int CAPTCHA_IGNORED_COUNT = 3;

	/**
	 * 是否做验证码检查
	 */
	public static boolean isCheckCaptcha(HttpServletRequest request) {
		return SecurityUtil.getFailedCount(request) >= CAPTCHA_IGNORED_COUNT;
	}

	/**
	 * 是否通过验证
	 */
	public static boolean isPassedCaptchaValidate(HttpServletRequest request, String inputCaptcha) {
		return isPassedCaptchaValidate("kcaptcha", request, inputCaptcha);
	}

	public static boolean isPassedCaptchaValidate(String type, HttpServletRequest request, String inputCaptcha) {
		try {
			if ("jcaptcha".equals(type)) {
				/*return SimpleImageCaptchaServlet.service.validateResponseForID(
				        (String)request.getSession().getId(),inputCaptcha);*/
			} else if ("kcaptcha".equals(type)) {
				String captcha = (String) request.getSession().getAttribute(
						com.google.code.kaptcha.Constants.KAPTCHA_SESSION_KEY);
				return captcha != null && captcha.equalsIgnoreCase(inputCaptcha);
			}
		} catch (Exception e) {
			//return false;
		}

		return false;
	}

	/**
	 * 取得登录失败次数
	 */
	public static int getFailedCount(HttpServletRequest request) {
		Integer failed_count = (Integer) request.getSession().getAttribute(SessionKey.LOGIN_FAILURE_COUNT);
		return (failed_count == null) ? 0 : failed_count;
	}

	/**
	 * 设置登录失败次数
	 */
	public static void setFailedCount(HttpServletRequest request, int count) {
		request.getSession().setAttribute(SessionKey.LOGIN_FAILURE_COUNT, count);
	}

	/**
	 * 添加失败次数
	 */
	public static void incFailedCount(HttpServletRequest request) {
		setFailedCount(request, getFailedCount(request) + 1);
	}

	/**
	 * 清除失败次数
	 */
	public static void clearFailedCount(HttpServletRequest request) {
		setFailedCount(request, 0);
	}

	/**
	 * 登录用户名
	 */
	public static String getPrincipal() {
		//todo:
		//		String security = SpringContextHolder.getApplicationContext()
		//			.getInitParameter( "secuirtyFramework");
		return getPrincipal("secuirtyFramework");
	}

	/**
	 * 登录用户名
	 */
	public static String getPrincipal(String security) {
		if (SecuirtyFramework.SHIRO.getValue().equalsIgnoreCase(security)) {
			Object obj = SecurityUtils.getSubject().getPrincipal();
			return obj == null ? null : obj.toString();
		} else {
			UserDetails ud = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
			return ud == null ? "" : ud.getUsername();
		}
	}

}
