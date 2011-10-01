package com.syspeak.itboss.security.shiro;



import javax.servlet.http.HttpServletRequest;

import org.apache.shiro.SecurityUtils;


public class SecurityUtil {

	/**
	 * 显示验证码容忍次数（登录失败N次显示验证码）
	 */
	public final static int CAPTCHA_IGNORED_COUNT = 3;
    /** 登录失败次数 */
	public static final String LOGIN_FAILURE_COUNT = "login_failure_count";

	/**
	 * 是否做验证码检查
	 */
	public static boolean isCheckCaptcha( HttpServletRequest request ){
		return SecurityUtil.getFailedCount( request ) >= CAPTCHA_IGNORED_COUNT;
	}

	/**
	 * 是否通过验证
	 */
	public static boolean isPassedCaptchaValidate( HttpServletRequest request,String inputCaptcha ){
		return isPassedCaptchaValidate("kcaptcha",request,inputCaptcha);
	}

	public static boolean isPassedCaptchaValidate( String type,HttpServletRequest request,String inputCaptcha ){
		try{
			if( "jcaptcha".equals(type)){
				/*return SimpleImageCaptchaServlet.service.validateResponseForID(
					(String)request.getSession().getId(),inputCaptcha);*/
			}else if("kcaptcha".equals(type)){
				String captcha = (String)request.getSession().getAttribute(
						com.google.code.kaptcha.Constants.KAPTCHA_SESSION_KEY);
				return captcha!=null && captcha.equalsIgnoreCase(inputCaptcha);
			}
		}catch( Exception e ){
			//return false;
		}

		return false;
	}

	/**
	 * 取得登录失败次数
	 */
	public static int getFailedCount( HttpServletRequest request ){
		Integer failed_count = (Integer) request.getSession().getAttribute(
				SecurityUtil.LOGIN_FAILURE_COUNT);
		return (failed_count == null) ? 0 : failed_count;
	}

	/**
	 * 设置登录失败次数
	 */
	public static void setFailedCount( HttpServletRequest request,int count ){
		request.getSession().setAttribute(SecurityUtil.LOGIN_FAILURE_COUNT,count);
	}

	/**
	 * 添加失败次数
	 */
	public static void incFailedCount( HttpServletRequest request){
		setFailedCount(request,getFailedCount( request )+1);
	}

	/**
	 * 清除失败次数
	 */
	public static void clearFailedCount( HttpServletRequest request){
		setFailedCount(request,0);
	}



	/**
	 * 登录用户名
	 */
	public static String getPrincipal(){

			Object obj= SecurityUtils.getSubject().getPrincipal();
			return obj==null?null:obj.toString();

	}

}
