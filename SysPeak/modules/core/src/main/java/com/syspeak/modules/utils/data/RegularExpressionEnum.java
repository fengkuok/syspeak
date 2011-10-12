package com.syspeak.modules.utils.data;

/**
 * 常用正则表达式字串枚举类
 * @company SysPeak (C) Copyright
 * @category RegularExpressionEnum
 * @version 1.0
 * @since 2011-10-12
 * @author JemiZhuu(周士淳)
 */
public enum RegularExpressionEnum {
	/**数字*/
	NUMBER("^[-+]?[\\d]+[.]?[\\d]*"),
	/**整数*/
	INTEGER("^[-+]?[\\d]+");

	private String expression;

	private RegularExpressionEnum(String expression) {
		this.expression = expression;
	}

	public String getExpression() {
		return expression;
	}

	/**
	 * 验证字串是否完全符合表达式
	 * @param target
	 * @return
	 */
	public boolean isMatches(String target) {
		return target != null && target.matches(expression);
	}

	@Override
	public String toString() {
		return expression;
	}

	public static void main(String[] args) {
		String target = "-023.";
		System.out.println(NUMBER.isMatches(target));
		Double number = Double.parseDouble(target);
		System.out.println(number);
	}
}
