package com.syspeak.makereap.workflow.functional.account;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.openqa.selenium.By;
import org.springside.modules.test.groups.Groups;

import com.syspeak.makereap.workflow.functional.BaseFunctionalTestCase;
import com.syspeak.makereap.workflow.functional.Gui;
import com.syspeak.makereap.workflow.functional.Gui.UserColumn;

/**
 * 系统安全控制的功能测试, 测试主要用户故事.
 * 
 * @author calvin
 */
public class SecurityTest extends BaseFunctionalTestCase {

	/**
	 * 测试匿名用户访问系统时的行为.
	 */
	@Test
	@Groups(NIGHTLY)
	public void checkAnonymous() {
		//访问退出登录页面,退出之前的登录
		s.open("/login!logout.action");
		assertEquals("Mini-Web 登录页", s.getTitle());

		//访问任意页面会跳转到登录界面
		s.open("/account/user.action");
		assertEquals("Mini-Web 登录页", s.getTitle());
	}

	/**
	 * 只有用户权限组的操作员访问系统时的受限行为.
	 */
	@Test
	@Groups(NIGHTLY)
	public void checkUserPermission() {
		//访问退出登录页面,退出之前的登录
		s.open("/login!logout.action");
		assertEquals("Mini-Web 登录页", s.getTitle());

		//登录普通用户
		s.type(By.name("username"), "user");
		s.type(By.name("password"), "user");
		s.clickTo(By.xpath(Gui.BUTTON_LOGIN));

		//校验用户权限组的操作单元格只有查看
		s.clickTo(By.linkText(Gui.MENU_USER));
		assertEquals("查看", s.getTable(By.xpath("//table[@id='contentTable']"), 1, UserColumn.OPERATIONS.ordinal()));
	}
}
