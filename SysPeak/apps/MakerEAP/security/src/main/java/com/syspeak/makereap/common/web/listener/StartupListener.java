package com.syspeak.makereap.common.web.listener;



import javax.servlet.ServletContextEvent;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.support.WebApplicationContextUtils;



/**
 * container startup listener
 */
public class StartupListener extends ContextLoaderListener{

	private static Log log = LogFactory.getLog(StartupListener.class);

	public static final String APP_REAL_PATH = "appRealPath";

	public void contextDestroyed(ServletContextEvent sce) {
		super.contextDestroyed(sce); //Spring
	}

	/**
	 * init system resource
	 */
	public void contextInitialized(ServletContextEvent sce) {
		super.contextInitialized(sce); //Spring

        ApplicationContext ctx = WebApplicationContextUtils
        	.getRequiredWebApplicationContext(sce.getServletContext());

		log.debug( "系统初始化..." );
	//	initScheduler( ctx );
	//	initRootUser( ctx );
	}

	/**
	 * 初始系统账户
	 */
	private void initRootUser( ApplicationContext ctx ){

	}

	/**
	 * 初始化定时任务
	 */
	private void initScheduler( ApplicationContext ctx ){


	}

}
