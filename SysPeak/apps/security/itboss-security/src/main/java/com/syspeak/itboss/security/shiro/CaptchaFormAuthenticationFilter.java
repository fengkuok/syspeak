package com.syspeak.itboss.security.shiro;



import java.util.Date;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.web.filter.authc.FormAuthenticationFilter;
import org.apache.shiro.web.util.WebUtils;



/**
 * 扩展“验证码”
 */
public class CaptchaFormAuthenticationFilter extends FormAuthenticationFilter{

	public static final String DEFAULT_CAPTCHA_PARAM = "captcha";

	private String captchaParam = DEFAULT_CAPTCHA_PARAM;


	public String getCaptchaParam() {
        return captchaParam;
    }


	public void setCaptchaParam(String captchaParam) {
		this.captchaParam = captchaParam;
	}

	protected String getCaptcha(ServletRequest request) {
        return WebUtils.getCleanParam(request, getCaptchaParam());
    }

    protected CaptchaUsernamePasswordToken createToken(ServletRequest request, ServletResponse response) {
        String username = getUsername(request);
        String password = getPassword(request);
        String captcha = getCaptcha(request);
        boolean rememberMe = isRememberMe(request);
        String host = getHost(request);

        return new CaptchaUsernamePasswordToken(username, password, rememberMe, host,captcha);
    }

	/**
	 * 验证码认证
	 */
	protected void doCaptchaValidate( HttpServletRequest request ,CaptchaUsernamePasswordToken token ){
		if( SecurityUtil.isCheckCaptcha( request ) &&
			!SecurityUtil.isPassedCaptchaValidate(request, token.getCaptcha() )){
			throw new ShiroBadCaptchaException("验证码错误！");
		}
	}

    protected boolean executeLogin(ServletRequest request, ServletResponse response) throws Exception {
    	CaptchaUsernamePasswordToken token = createToken(request, response);
        if (token == null) {
            String msg = "方法createToken()返回空值，登录操作必须获得非空的AuthenticationToken！";
            throw new IllegalStateException(msg);
        }

        try {
        	doCaptchaValidate( (HttpServletRequest)request,token );

            Subject subject = getSubject(request, response);
            subject.login(token);

            SecurityUtil.clearFailedCount((HttpServletRequest)request );//清除失败次数

            //更换用户登录后，刷新页头
            Cookie cookie = new Cookie("REFRESH-HEADER","TRUE");
        	cookie.setPath( ((HttpServletRequest)request).getContextPath() );
        	((HttpServletResponse)response).addCookie( cookie );

        	//todo:登录日志

            return onLoginSuccess(token, subject, request, response);
        } catch (AuthenticationException e) {
        	SecurityUtil.incFailedCount((HttpServletRequest)request);//登录失败次数

            return onLoginFailure(token, e, request, response);
        }
    }

    /**
     * 登录失败用于前端信息提示
     */
    protected void setFailureAttribute(ServletRequest request, AuthenticationException ae) {
        request.setAttribute(getFailureKeyAttribute(), ae);
    }

}
