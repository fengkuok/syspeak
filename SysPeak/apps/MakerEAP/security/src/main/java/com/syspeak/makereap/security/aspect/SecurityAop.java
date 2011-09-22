package com.syspeak.makereap.security.aspect;

import java.util.List;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.hibernate.Hibernate;
import org.springframework.stereotype.Component;

import com.syspeak.makereap.security.domain.logic.UserAccountService;
import com.syspeak.makereap.security.domain.model.UserAccount;


@Aspect
@Component
public class SecurityAop {
	@Pointcut("execution(* com.syspeak.makereap.security.domain.logic.UserAccountService.*(..))")
	public void getUserAccountListCut() {
	}

	// 方法执行前开始下面代码
	@Before("getUserAccountListCut()&&args()")
	public void doAccessCheck() {
		System.out.println("前置通知");
	}

	// 方法执行完毕开始下面代码
	@AfterReturning(pointcut = "SecurityPointCuts.userAccountService()", returning = "list")
	public void afterReturning(List<? extends UserAccount> list) {
//		for(UserAccount user : list){
//			Hibernate.initialize(user.getRoles());
//		}
		
		System.out.println("后置通知,返回id为" + list);
	}

	// 相当于final语句块，
	@After("getUserAccountListCut()")
	public void after() {
		System.out.println("最后通知");
	}

	@AfterThrowing(pointcut = "getUserAccountListCut()", throwing = "e")
	public void afterThrowtin(Exception e) {
		System.out.println("异常通知" + e);
	}

	@Around("SecurityPointCuts.userAccountService()")
	public Object doBasicProfiling(ProceedingJoinPoint pjp) throws Throwable {
		System.out.println("开始环绕通知");// 前置通知后执行
		// 获取被切入方法名称
		String methodName = pjp.getSignature().getName();
		Object retObj = null;
		if(methodName.equals(UserAccountService.GET_USER_ACCOUNT_LIST)){
			retObj = pjp.proceed();
			for(UserAccount user : (List<UserAccount>)retObj){
				Hibernate.initialize(user.getRoles());
			}
			
		}
		
//		// 获取被切入方法参数
//		Object[] args = pjp.getArgs();
//		Class[] classes = new Class[args.length];
//		for (int i = 0; i < args.length; i++) {
//			classes[i] = args[i].getClass();
//		}
//		// 获取Class
//		Class targetClass = pjp.getTarget().getClass();
//		// 获取此方法
//		Method method = targetClass.getMethod(methodName, classes);
		System.out.println("====class " + methodName);
		//Object obj = pjp.proceed();// 此处返回的是拦截的方法的返回值，如果不执行此方法，则不会执行被拦截的方法，利用环绕通知可以很好的做权限管理
		System.out.println(retObj + "结束环绕通知");// 后置通知后、最后通知前执行
		return retObj;
	}
}


////获取被切入方法名称
//String methodName = pjp.getSignature().getName();
////获取被切入方法参数
//Object[] args = pjp.getArgs();
//Class[] classes = new Class[args.length];
//for(int i = 0; i < args.length; i++){
//	classes[i] = args[i].getClass();
//}
////获取Class
//Class targetClass = pjp.getTarget().getClass();
////获取此方法
//Method method = targetClass.getMethod(methodName,  classes);
////是否存在Annotation NoTransactional 
//boolean hasAnnotation = method.isAnnotationPresent(NoTransactional.class); 
//if(hasAnnotation){
//	NoTransactional annotation = method.getAnnotation(NoTransactional.class);   
//	logger.info("此方法不执行事物处理,描述为 ： " + annotation.description());
//	return pjp.proceed(); 
//}
