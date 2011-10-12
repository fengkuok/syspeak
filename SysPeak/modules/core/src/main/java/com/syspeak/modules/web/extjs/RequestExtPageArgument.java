package com.syspeak.modules.web.extjs;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * ExtJS分页Request对象参数注解
 * @company SysPeak (C) Copyright
 * @category RequestExtPage
 * @version 1.0
 * @since 2011-10-12
 * @author JemiZhuu(周士淳)
 */
@Target(ElementType.PARAMETER)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface RequestExtPageArgument {
	String value() default "";

	String pageNoParam() default "page";

	String pageSizeParam() default "limit";

	String sortParam() default "sort";
}
