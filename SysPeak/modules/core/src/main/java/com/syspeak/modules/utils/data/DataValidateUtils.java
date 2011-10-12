package com.syspeak.modules.utils.data;

import org.apache.commons.lang.StringUtils;

/**
 * 数据值验证工具类
 * @company SysPeak (C) Copyright
 * @category DataValidationUtils
 * @version 1.0
 * @since 2011-10-12
 * @author JemiZhuu(周士淳)
 */
public abstract class DataValidateUtils {

	/**
	 * 判断字串是否为空
	 * @param target
	 * @return
	 */
	public static boolean isBlank(String target) {
		return StringUtils.isBlank(target);
	}

	/**
	 * 是否合法的数字字串
	 * @param target
	 * @return
	 */
	public static boolean isNumberString(String target) {
		return RegularExpressionEnum.NUMBER.isMatches(target);
	}

	/**
	 * 是否有效的整数字串
	 * @param target
	 * @return
	 */
	public static boolean isIntegerString(String target) {
		return RegularExpressionEnum.INTEGER.isMatches(target);
	}

}
