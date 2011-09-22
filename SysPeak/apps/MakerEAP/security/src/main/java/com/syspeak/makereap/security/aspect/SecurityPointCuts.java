package com.syspeak.makereap.security.aspect;

import org.aspectj.lang.annotation.Pointcut;

public final class SecurityPointCuts {
	private SecurityPointCuts(){
	}
	
	@Pointcut("execution(* com.syspeak.makereap.security.domain.logic.UserAccountService.*(..))")
	public void userAccountService(){}
	
	
	@Pointcut("execution(@InitUserAccounts * *(..))")
	public void initUserAccounts(){}
}
